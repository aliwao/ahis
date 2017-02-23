package cn.com.liandisys.ahis.webapp.mapper;

import java.util.List;

import cn.com.liandisys.ahis.webapp.entity.BankCardInfoEntity;

public interface Mpst006Mapper {

	List<BankCardInfoEntity> getCardsByUserId(Long userid);

	int getCntByUserId(Integer userId);

	BankCardInfoEntity getCardByPrimaryKey(BankCardInfoEntity card);
	
	int insert(BankCardInfoEntity card);

	int deleteByPrimaryKey(BankCardInfoEntity card);

}
