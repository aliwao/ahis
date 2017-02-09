package cn.com.liandisys.ahis.webapp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.liandisys.ahis.webapp.entity.BankCardInfoEntity;
import cn.com.liandisys.ahis.webapp.mapper.Mpst006Mapper;

/**
 * 银行卡绑定页面Service。
 * 
 * @author xuyue
 * @version 1.0
 */
@Service
@Transactional
public class Mpst006Service {

	@Autowired
	private Mpst006Mapper mpst006Mapper;

	private static final Logger logger = LoggerFactory.getLogger(Mpst006Service.class);

	/**
	 * 检索用户所有绑定的银行卡。
	 * 
	 * @param userId
	 *            用户ID
	 * @return 银行卡信息
	 */
	public List<BankCardInfoEntity> getCardsByUserId(Long userId) {
		logger.trace("" + userId);
		return mpst006Mapper.getCardsByUserId(userId);
	}

	/**
	 * 检索银行卡信息。
	 * 
	 * @param card
	 *            用户ID、银行卡号
	 * @return 银行卡信息
	 */
	public BankCardInfoEntity getCardByPrimaryKey(BankCardInfoEntity card) {
		logger.trace("" + card.getUserId());
		return mpst006Mapper.getCardByPrimaryKey(card);
	}

	/**
	 * 银行卡绑定 存入DB。
	 * 
	 * @param card
	 *            绑定的银行卡信息
	 * @return 插入DB件数
	 */
	public int insert(BankCardInfoEntity card) {
		logger.trace("" + card.getUserId());
		return mpst006Mapper.insert(card);
	}

	/**
	 * 解除银行卡绑定 删除DB。
	 * 
	 * @param card
	 *            用户ID、银行卡号
	 * @return 删除DB件数
	 */
	public int deleteByPrimaryKey(BankCardInfoEntity card) {
		logger.trace("" + card.getUserId());
		return mpst006Mapper.deleteByPrimaryKey(card);
	}

}
