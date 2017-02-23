package cn.com.liandisys.ahis.webapp.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.liandisys.ahis.webapp.dto.PaymentRecordDto;
import cn.com.liandisys.ahis.webapp.his.entity.response.HospitalizationRecordItem;
import cn.com.liandisys.ahis.webapp.mapper.Mfis009Mapper;
import cn.com.liandisys.ahis.webapp.utils.AhisCommonUtil;

/**
 * 押金补缴页面Service。
 * 
 * @author xuyue
 * @version 1.0
 */
@Service
@Transactional
public class Mfis009Service {

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
	public int insertPaymentRecord(String paymentNo, String payFee, HospitalizationRecordItem stayItem) {

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
