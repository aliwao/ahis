package cn.com.liandisys.ahis.webapp.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.apache.http.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.liandisys.ahis.webapp.dto.PaymentRecordDto;
import cn.com.liandisys.ahis.webapp.his.entity.request.base.HospitalizationBaseHisRequest;
import cn.com.liandisys.ahis.webapp.his.entity.request.base.HospitalizationFeeBaseHisRequest;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.HospitalizationBaseHisResponse;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.HospitalizationFeeBaseHisResponse;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.item.HospitalizationBaseItem;
import cn.com.liandisys.ahis.webapp.his.factory.HospitalizationFeeHisExecuteLogicFactory;
import cn.com.liandisys.ahis.webapp.his.factory.HospitalizationHisExecuteLogicFactory;
import cn.com.liandisys.ahis.webapp.his.logic.base.AbstractHospitalizationFeeHisExecuteLogic;
import cn.com.liandisys.ahis.webapp.his.logic.base.AbstractHospitalizationHisExecuteLogic;
import cn.com.liandisys.ahis.webapp.mapper.Mfis009Mapper;
import cn.com.liandisys.ahis.webapp.utils.AhisCommonUtil;

/**
 * 住院服务Service。
 * 
 * @author xuyue
 * @version 1.0
 */
@Service
@Transactional
public class HospitalizationService {

	@Autowired
	private HospitalizationHisExecuteLogicFactory hospitalizationHisExecuteLogicFactory;

	@Autowired
	private HospitalizationFeeHisExecuteLogicFactory hospitalizationFeeHisExecuteLogicFactory;

	/**
	 * 无锡三院 住院记录查询mock请求。
	 * 
	 * @param request
	 *            诊疗卡类型、诊疗卡号
	 * @return 科室信息
	 * @throws UnsupportedEncodingException
	 * @throws JAXBException
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping
	public List<HospitalizationBaseItem> getWx3yHospitalizationRecord(HospitalizationBaseHisRequest request) {
		AbstractHospitalizationHisExecuteLogic logic = hospitalizationHisExecuteLogicFactory.getLogic();
		HospitalizationBaseHisResponse respone = logic.execute(request);

		if (respone.getItemList() != null) {
			return respone.getItemList();
		}
		return new ArrayList<>();
	}

	/**
	 * 无锡三院 住院费用清单查询 mock请求。
	 * 
	 * @param request
	 *            诊疗卡类型、诊疗卡号、住院号、清单开始日期、清单结束日期
	 * @return 住院费用清单
	 * @throws UnsupportedEncodingException
	 * @throws JAXBException
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping
	public HospitalizationFeeBaseHisResponse getWx3yHospitalizationFee(HospitalizationFeeBaseHisRequest request) {
		AbstractHospitalizationFeeHisExecuteLogic logic = hospitalizationFeeHisExecuteLogicFactory.getLogic();
		HospitalizationFeeBaseHisResponse respone = logic.execute(request);

		return respone;
	}

	@Autowired
	private Mfis009Mapper mfis009Mapper;

	/**
	 * 押金补缴 缴费情况存入DB。
	 * 
	 * @param paymentNo
	 *            缴费单号
	 * @param payFee
	 *            补缴金额
	 * @param stayItem
	 *            住院信息
	 * @return 插入DB件数
	 */
	public int insertPaymentRecord(String paymentNo, String payFee, HospitalizationBaseItem stayItem) {

		Timestamp nowDateTime = new Timestamp(System.currentTimeMillis());
		int userId = AhisCommonUtil.getCurrentUserInfo().getUserID();

		PaymentRecordDto dto = new PaymentRecordDto();
		dto.setDepartmentName(stayItem.getDeptName());
		dto.setDoctorName("");
		dto.setHisOrdNum(Integer.valueOf(stayItem.getAdmissionNum()));
		dto.setMedicalInsuranceAmount(0.00);
		dto.setMedicalselfAmount(0.00);
		dto.setOrderFee(Double.parseDouble(payFee));
		dto.setOrderType("1"); // 1:支付 
		dto.setPaidState("0"); // 0：未完成
		dto.setPaymentName("住院押金补缴");
		dto.setPaymentNo(paymentNo);
		dto.setPaymentNotice("0"); // 0：未通知
		dto.setPaymentRefType("2"); //2:住院押金补缴 
		dto.setUserId(userId);
		dto.setLoginTime(nowDateTime);
		dto.setLoginUser(String.valueOf(userId));
		dto.setUpdateTime(nowDateTime);
		dto.setUpdateUser(String.valueOf(userId));
		return mfis009Mapper.insertPaymentRecord(dto);
	}

}
