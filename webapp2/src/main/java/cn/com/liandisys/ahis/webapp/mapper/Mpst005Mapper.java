package cn.com.liandisys.ahis.webapp.mapper;

import cn.com.liandisys.ahis.webapp.entity.HospitalCardInfoEntity;

public interface Mpst005Mapper {

	HospitalCardInfoEntity getCardByPrimaryKey(HospitalCardInfoEntity card);

	String getCardByUserId(Integer userId);

	int insert(HospitalCardInfoEntity card);

	int deleteByPrimaryKey(HospitalCardInfoEntity card);

}
