package cn.com.liandisys.ahis.webapp.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.liandisys.ahis.webapp.dto.PaymentRecordDto;
import cn.com.liandisys.ahis.webapp.entity.RegisterRelateEntity;
import cn.com.liandisys.ahis.webapp.form.Mfrg005Form;
import cn.com.liandisys.ahis.webapp.mapper.Mfrg005Mapper;
import cn.com.liandisys.ahis.webapp.mapper.PaymentRecordMapper;
import cn.com.liandisys.ahis.webapp.utils.AhisCommonUtil;

@Service
public class Mfrg005Service {
	@Autowired
	private Mfrg005Mapper mfrg005Mapper;
	@Autowired
	private PaymentRecordMapper paymentRecordMapper;

	public RegisterRelateEntity getRegisterInfo(String psOrdNum) {

		return mfrg005Mapper.selectRegisterByRegisterNo(psOrdNum);
	}

	public PaymentRecordDto getPaymentRecord(Mfrg005Form mfrg005Form) {
		return paymentRecordMapper.getPaymentRecord(mfrg005Form.getPsOrdNum());
	}

	public String insertPaymentRecord(Mfrg005Form mfrg005Form) {
		Timestamp nowDateTime = new Timestamp(System.currentTimeMillis());
		int userId = AhisCommonUtil.getCurrentUserInfo().getUserID();

		PaymentRecordDto dto = new PaymentRecordDto();
		dto.setDepartmentName(mfrg005Form.getDeptName());
		dto.setDoctorName(mfrg005Form.getDoctorName());
		dto.setHisOrdNum(Integer.parseInt(mfrg005Form.getHisOrdNum()));
		dto.setMedicalInsuranceAmount(0.00);
		dto.setMedicalselfAmount(0.00);
		dto.setOrderFee(Double.parseDouble(mfrg005Form.getPayAmt()));
		dto.setOrderType("1"); // 1:支付
		dto.setPaidState("0"); // 0：未完成
		dto.setPaymentName("挂号缴费 ");
		dto.setPaymentNo(mfrg005Form.getPsOrdNum());
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
}
