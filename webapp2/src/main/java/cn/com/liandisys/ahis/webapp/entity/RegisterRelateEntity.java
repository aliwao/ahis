package cn.com.liandisys.ahis.webapp.entity;

import cn.com.liandisys.ahis.webapp.dto.DoctorBasicInfoDto;
import cn.com.liandisys.ahis.webapp.dto.PaymentRecordDto;

public class RegisterRelateEntity {

	private String registerNo;

	private RegisterHistoryEntity registerHistoryEntity;

	private DoctorBasicInfoDto doctorBasicInfoEntity;
	
	private PaymentRecordDto paymentRecordEntity;

	public String getRegisterNo() {
		return registerNo;
	}

	public void setRegisterNo(String registerNo) {
		this.registerNo = registerNo;
	}

	public RegisterHistoryEntity getRegisterHistoryEntity() {
		return registerHistoryEntity;
	}

	public void setRegisterHistoryEntity(RegisterHistoryEntity registerHistoryEntity) {
		this.registerHistoryEntity = registerHistoryEntity;
	}

	public DoctorBasicInfoDto getDoctorBasicInfoEntity() {
		return doctorBasicInfoEntity;
	}

	public void setDoctorBasicInfoEntity(DoctorBasicInfoDto doctorBasicInfoEntity) {
		this.doctorBasicInfoEntity = doctorBasicInfoEntity;
	}

	public PaymentRecordDto getPaymentRecordEntity() {
		return paymentRecordEntity;
	}

	public void setPaymentRecordEntity(PaymentRecordDto paymentRecordEntity) {
		this.paymentRecordEntity = paymentRecordEntity;
	}
}
