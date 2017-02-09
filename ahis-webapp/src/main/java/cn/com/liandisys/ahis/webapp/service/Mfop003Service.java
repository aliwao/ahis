package cn.com.liandisys.ahis.webapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.liandisys.ahis.webapp.controller.Mpst004Controller;
import cn.com.liandisys.ahis.webapp.entity.HospitalOrderEntity;
import cn.com.liandisys.ahis.webapp.mapper.Mfop003Mapper;

/**
 * 缴费实行Service。
 * 
 */
@Service
@Transactional
public class Mfop003Service {

	@Autowired
	private Mfop003Mapper mfop003Mapper;

	private static final Logger logger = LoggerFactory.getLogger(Mpst004Controller.class);

	/**
	 * 缴费详细作成。
	 * 
	 * @param card
	 *            缴费信息
	 * @return 插入DB件数
	 */
	public int insert(HospitalOrderEntity hisOrd) {
		logger.trace("" + hisOrd.getUserId());
		logger.trace("" + hisOrd.getHisOrdNum());
		return mfop003Mapper.insert(hisOrd);
	}
	
	/**
	 * 缴费详细查询。
	 * 
	 * @param card
	 *            缴费信息
	 * @return 取得件数
	 */
	public int select(HospitalOrderEntity hisOrd) {
		logger.trace("" + hisOrd.getUserId());
		logger.trace("" + hisOrd.getHisOrdNum());
		return mfop003Mapper.select(hisOrd);
	}
}
