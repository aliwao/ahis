package cn.com.liandisys.ahis.webapp.mapper;

import org.apache.ibatis.annotations.Param;

import cn.com.liandisys.ahis.webapp.dto.PersonPaymentInfoEntity;

public interface PersonPaymentInfoMapper {

	void updateDiagnosisCardNoByUserID(@Param("userID") long userID, @Param("diagnosisCardNo") String diagnosisCardNo);

	void insertNewRecord(PersonPaymentInfoEntity entity);

	PersonPaymentInfoEntity getDiagnosisCardNoByUserID(long userID);
}
