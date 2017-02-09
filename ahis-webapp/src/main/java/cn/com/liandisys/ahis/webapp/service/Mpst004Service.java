package cn.com.liandisys.ahis.webapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.liandisys.ahis.webapp.entity.MedicareCardInfoEntity;
import cn.com.liandisys.ahis.webapp.mapper.Mpst004Mapper;

/**
 * 医保卡绑定页面Service。
 * 
 * @author xuyue
 * @version 1.0
 */
@Service
@Transactional
public class Mpst004Service {

	@Autowired
	private Mpst004Mapper mpst004Mapper;

	private static final Logger logger = LoggerFactory.getLogger(Mpst004Service.class);

	/**
	 * 检索医保卡信息。
	 * 
	 * @param card
	 *            用户ID、医保卡号
	 * @return 医保卡信息
	 */
	public MedicareCardInfoEntity getCardByPrimaryKey(MedicareCardInfoEntity card) {
		logger.trace("" + card.getUserId());
		return mpst004Mapper.getCardByPrimaryKey(card);
	}

	/**
	 * 通过userId 检索医保卡信息。
	 * 
	 * @param userId
	 *            用户ID
	 * @return 医保卡信息
	 */
	public String getCardByUserId(Integer userId) {
		logger.trace("" + userId);
		return mpst004Mapper.getCardByUserId(userId);
	}

	/**
	 * 医保卡绑定 存入DB。
	 * 
	 * @param card
	 *            绑定的医保卡信息
	 * @return 插入DB件数
	 */
	public int insert(MedicareCardInfoEntity card) {
		logger.trace("" + card.getUserId());
		return mpst004Mapper.insert(card);
	}

	/**
	 * 解除医保卡绑定 删除DB。
	 * 
	 * @param card
	 *            绑定的医保卡信息
	 * @return 删除DB件数
	 */
	public int deleteByPrimaryKey(MedicareCardInfoEntity card) {
		logger.trace("" + card.getUserId());
		return mpst004Mapper.deleteByPrimaryKey(card);
	}

}
