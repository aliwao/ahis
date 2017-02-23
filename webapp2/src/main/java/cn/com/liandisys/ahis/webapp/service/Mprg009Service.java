package cn.com.liandisys.ahis.webapp.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisService;
import cn.com.liandisys.ahis.webapp.dto.LoginUserInfo;
import cn.com.liandisys.ahis.webapp.dto.PaymentRecordDto;
import cn.com.liandisys.ahis.webapp.entity.RegRecordEntity;
import cn.com.liandisys.ahis.webapp.entity.RegisterRelateEntity;
import cn.com.liandisys.ahis.webapp.form.Mprg009Form;
import cn.com.liandisys.ahis.webapp.his.entity.request.base.AppointmentCancelBaseHisRequest;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.AppointmentCancelBaseHisResponse;
import cn.com.liandisys.ahis.webapp.his.factory.AppointmentCancelHisExecuteLogicFactory;
import cn.com.liandisys.ahis.webapp.his.logic.base.AbstractAppointmentCancelHisExecuteLogic;
import cn.com.liandisys.ahis.webapp.mapper.Mprg009Mapper;
import cn.com.liandisys.ahis.webapp.mapper.PaymentRecordMapper;
import cn.com.liandisys.ahis.webapp.mapper.RegisterHistoryMapper;
import cn.com.liandisys.ahis.webapp.utils.AhisCommonUtil;

@Service
public class Mprg009Service extends AbstractAhisService<Mprg009Form> {
	@Autowired
	private Mprg009Mapper mprg009Mapper;
	@Autowired
	private RegisterHistoryMapper registerHistoryMapper;
	@Autowired
	private PaymentRecordMapper paymentRecordMapper;
	@Autowired
	AppointmentCancelHisExecuteLogicFactory cancalFactory;

	public List<RegRecordEntity> searchRegRecord(LoginUserInfo loginUserInfo, String type) {
		long userId = (long) loginUserInfo.getUserID();
		List<RegisterRelateEntity> entities = mprg009Mapper.selectRegisterByUserID(userId);
		List<RegisterRelateEntity> newList = new ArrayList<>();
		if (type.equals("0")) {
			newList = new ItemSelector() {
				@Override
				boolean isMatch(RegisterRelateEntity item) {
					return true;
				}

			}.select(entities);
		} else if (type.equals("1")) {
			newList = new ItemSelector() {
				@Override
				boolean isMatch(RegisterRelateEntity item) {
					return isAppointed(item);
				}

			}.select(entities);
		} else if (type.equals("2")) {
			newList = new ItemSelector() {
				@Override
				boolean isMatch(RegisterRelateEntity item) {
					return isPayed(item);
				}

			}.select(entities);
		} else {
			newList = new ItemSelector() {
				@Override
				boolean isMatch(RegisterRelateEntity item) {
					return isCanceled(item);
				}

			}.select(entities);
		}
		return convItems(newList);
	}

	public PaymentRecordDto getPaymentRecord(Mprg009Form mprg009Form) {
		return paymentRecordMapper.getPaymentRecord(mprg009Form.getPsOrdNum());
	}

	public String insertPaymentRecord(Mprg009Form mprg009Form) {
		Timestamp nowDateTime = new Timestamp(System.currentTimeMillis());
		int userId = AhisCommonUtil.getCurrentUserInfo().getUserID();

		PaymentRecordDto dto = new PaymentRecordDto();
		dto.setDepartmentName(mprg009Form.getDeptName());
		dto.setDoctorName(mprg009Form.getDoctorName());
		dto.setHisOrdNum(Integer.parseInt(mprg009Form.getHisOrdNum()));
		dto.setMedicalInsuranceAmount(0.00);
		dto.setMedicalselfAmount(0.00);
		dto.setOrderFee(Double.parseDouble(mprg009Form.getRegFee()));
		dto.setOrderType("1"); // 1:支付
		dto.setPaidState("0"); // 0：未完成
		dto.setPaymentName("挂号缴费 ");
		dto.setPaymentNo(mprg009Form.getPsOrdNum());
		dto.setPaymentNotice("0"); // 0：未通知
		dto.setPaymentRefType("1"); // 1:挂号预约缴费
		dto.setUserId(userId);
		dto.setLoginTime(nowDateTime);
		dto.setLoginUser(String.valueOf(userId));
		dto.setUpdateTime(nowDateTime);
		dto.setUpdateUser(String.valueOf(userId));
		paymentRecordMapper.insertPaymentRecord(dto);
		return dto.getPaymentNo();

	}

	public String cancelAppointment(String hisOrdNum, String psOrdNum, String cancelReason) {
		AppointmentCancelBaseHisRequest req = new AppointmentCancelBaseHisRequest();
		req.setHisOrdNum(hisOrdNum);
		req.setPsOrdNum(psOrdNum);
		req.setCancelReason(cancelReason);
		AbstractAppointmentCancelHisExecuteLogic logic = cancalFactory.getLogic();
		AppointmentCancelBaseHisResponse res = logic.execute(req);
		if (res.getResultCode().equals("0")) {
			registerHistoryMapper.updateStatusByKey(psOrdNum, "1");
			return "success";
		}

		return "error";
	}

	private abstract class ItemSelector {
		public List<RegisterRelateEntity> select(List<RegisterRelateEntity> list) {
			List<RegisterRelateEntity> newList = new ArrayList<>();
			list.forEach(item -> {
				if (isMatch(item)) {
					newList.add(item);
				}
			});
			return newList;
		}

		abstract boolean isMatch(RegisterRelateEntity item);
	}

	private List<RegRecordEntity> convItems(List<RegisterRelateEntity> items) {
		List<RegRecordEntity> entityList = new ArrayList<>();
		items.forEach(item -> {
			RegRecordEntity entity = createEntity(item);
			entityList.add(entity);
		});
		return entityList;
	}

	private RegRecordEntity createEntity(RegisterRelateEntity item) {
		RegRecordEntity entity = new RegRecordEntity();
		entity.setDeptCode(item.getDoctorBasicInfoEntity().getDepartmentCode());
		entity.setDeptName(item.getDoctorBasicInfoEntity().getDepartmentName());
		entity.setDoctorCode(item.getDoctorBasicInfoEntity().getDoctorCode());
		entity.setDoctorName(item.getDoctorBasicInfoEntity().getDoctorName());
		entity.setHisOrdNum(item.getRegisterHistoryEntity().getHisOrdNum());
		entity.setLastUpdateTime(convDateToString(item.getRegisterHistoryEntity().getRegisterDate()));
		entity.setRegFee(String.valueOf(item.getRegisterHistoryEntity().getRegisterFee()));
		entity.setScheduleDate(convDateToString(item.getRegisterHistoryEntity().getHappenDate())
				.concat(getWeekByDateStr(item.getRegisterHistoryEntity().getHappenDate())));
		entity.setTimeFlag(getTimeFlag(item.getRegisterHistoryEntity().getHappenPeriod()));
		entity.setOrdStatus(getOrdStatus(item));
		entity.setDoctorTitle(item.getDoctorBasicInfoEntity().getRank());
		entity.setPsOrdNum(item.getRegisterHistoryEntity().getRegisterNo());
		return entity;
	}

	private boolean isAppointed(RegisterRelateEntity item) {
		return item.getRegisterHistoryEntity().getRegisterStatus().equals("0")
				&& (null == item.getPaymentRecordEntity() || item.getPaymentRecordEntity().getPaidState().equals("0"));
	}

	private boolean isPayed(RegisterRelateEntity item) {
		return item.getRegisterHistoryEntity().getRegisterStatus().equals("0") && null != item.getPaymentRecordEntity()
				&& item.getPaymentRecordEntity().getPaidState().equals("1");
	}

	private boolean isCanceled(RegisterRelateEntity item) {
		return item.getRegisterHistoryEntity().getRegisterStatus().equals("1");
	}

	private String getOrdStatus(RegisterRelateEntity item) {
		if (isAppointed(item)) {
			return "0";
		} else if (isPayed(item)) {
			return "1";
		} else {
			return "2";
		}
	}

	private String getTimeFlag(String timeFlag) {
		if (timeFlag.equals("1")) {
			return "上午";
		} else {
			return "下午";
		}
	}

	private String convDateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		return sdf.format(date);
	}

	private String getWeekByDateStr(Date date) {

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		String week = "";
		int weekIndex = c.get(Calendar.DAY_OF_WEEK);

		switch (weekIndex) {
		case 1:
			week = "周日";
			break;
		case 2:
			week = "周一";
			break;
		case 3:
			week = "周二";
			break;
		case 4:
			week = "周三";
			break;
		case 5:
			week = "周四";
			break;
		case 6:
			week = "周五";
			break;
		case 7:
			week = "周六";
			break;
		}
		return week;
	}
}
