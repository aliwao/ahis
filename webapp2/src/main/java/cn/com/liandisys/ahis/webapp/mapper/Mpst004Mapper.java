package cn.com.liandisys.ahis.webapp.mapper;

import cn.com.liandisys.ahis.webapp.entity.MedicareCardInfoEntity;

public interface Mpst004Mapper {

	MedicareCardInfoEntity getCardByPrimaryKey(MedicareCardInfoEntity card);

	String getCardByUserId(Integer userId);

	int insert(MedicareCardInfoEntity card);

	int deleteByPrimaryKey(MedicareCardInfoEntity card);

}
