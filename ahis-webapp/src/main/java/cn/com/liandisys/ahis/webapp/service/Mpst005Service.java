package cn.com.liandisys.ahis.webapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.liandisys.ahis.webapp.entity.HospitalCardInfoEntity;
import cn.com.liandisys.ahis.webapp.mapper.Mpst005Mapper;

/**
 * 就诊卡绑定页面Service。
 * 
 * @author xuyue
 * @version 1.0
 */
@Service
@Transactional
public class Mpst005Service {

	@Autowired
	private Mpst005Mapper mpst005Mapper;

	private static final Logger logger = LoggerFactory.getLogger(Mpst005Service.class);

	/**
	 * 检索就诊卡信息。
	 * 
	 * @param userId
	 *            用户ID
	 * @return 就诊卡信息
	 */
	public HospitalCardInfoEntity getCardByPrimaryKey(HospitalCardInfoEntity card) {
		logger.trace("" + card.getUserId());
		return mpst005Mapper.getCardByPrimaryKey(card);
	}

	/**
	 * 通过userId 检索就诊卡信息。
	 * 
	 * @param userId
	 *            用户ID
	 * @return 就诊卡信息
	 */
	public String getCardByUserId(Integer userId) {
		logger.trace("" + userId);
		return mpst005Mapper.getCardByUserId(userId);
	}

	/**
	 * 就诊卡绑定 存入DB。
	 * 
	 * @param card
	 *            绑定的就诊卡信息
	 * @return 插入DB件数
	 */
	public int insert(HospitalCardInfoEntity card) {
		logger.trace("" + card.getUserId());
		return mpst005Mapper.insert(card);
	}

	/**
	 * 解除就诊卡绑定 删除DB。
	 * 
	 * @param card
	 *            绑定的就诊卡信息
	 * @return 删除DB件数
	 */
	public int deleteByPrimaryKey(HospitalCardInfoEntity card) {
		logger.trace("" + card.getUserId());
		return mpst005Mapper.deleteByPrimaryKey(card);
	}

}
