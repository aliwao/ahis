package cn.com.liandisys.ahis.webapp.service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.liandisys.ahis.webapp.entity.FavoriteDoctorsEntity;
import cn.com.liandisys.ahis.webapp.his.HisHttpJson;
import cn.com.liandisys.ahis.webapp.his.entity.response.DoctorInfoItem;
import cn.com.liandisys.ahis.webapp.his.entity.response.DoctorInfoResponse;
import cn.com.liandisys.ahis.webapp.his.entity.response.RegisterInfoItem;
import cn.com.liandisys.ahis.webapp.his.entity.response.RegisterInfoResponse;
import cn.com.liandisys.ahis.webapp.mapper.Mfrg002Mapper;

/**
 * 预约挂号页面Service。
 * 
 * @author xuyue
 * @version 1.0
 */
@Service
@Transactional
public class Mfrg002Service {

	@Autowired
	private Mfrg002Mapper mfrg002Mapper;

	private static final Logger logger = LoggerFactory.getLogger(Mfrg002Service.class);

	/**
	 * 预约号源信息查询mock请求。
	 * 
	 * @return 预约号源信息
	 * @throws UnsupportedEncodingException
	 * @throws JAXBException
	 */
	@RequestMapping
	public List<RegisterInfoItem> getRegisterInfoList(JSONObject request) throws UnsupportedEncodingException, JAXBException {
		JSONObject json = HisHttpJson.executeHisApi("register-info", request);
		RegisterInfoResponse respone = HisHttpJson.convJsonToBean(json, RegisterInfoResponse.class);

		logger.debug(respone.getResultCode());
		logger.debug(respone.getResultMessage());

		if (respone.getItemList() != null) {
			respone.getItemList().forEach(item -> {
				logger.trace(item.getDeptCode());
				logger.trace(item.getDoctorCode());
			});
			return respone.getItemList();
		}
		return new ArrayList<>();
	}

	/**
	 * 医生信息查询mock请求。
	 * 
	 * @return 医生信息
	 * @throws UnsupportedEncodingException
	 * @throws JAXBException
	 */
	@RequestMapping
	public List<DoctorInfoItem> getDoctorInfoList(JSONObject request) throws UnsupportedEncodingException, JAXBException {

		JSONObject json = HisHttpJson.executeHisApi("doctor-info", request);
		DoctorInfoResponse respone = HisHttpJson.convJsonToBean(json, DoctorInfoResponse.class);

		logger.debug(respone.getResultCode());
		logger.debug(respone.getResultMessage());

		if (respone.getItemList() != null) {
			respone.getItemList().forEach(item -> {
				logger.trace(item.getDeptCode());
				logger.trace(item.getDoctorCode());
			});
			return respone.getItemList();
		}
		return new ArrayList<>();
	}

	/**
	 * 检索医生收藏。
	 * 
	 * @param favDoc
	 *            收藏信息
	 * @return 医生收藏信息
	 */
	public FavoriteDoctorsEntity getFavDocByPrimaryKey(FavoriteDoctorsEntity favDoc) {
		logger.trace("" + favDoc.getUserId());
		return mfrg002Mapper.getFavDocByPrimaryKey(favDoc);
	}

	/**
	 * 检索当前用户的一个科室的医生收藏。
	 * 
	 * @param favDoc
	 *            收藏信息
	 * @return 医生收藏信息
	 */
	public List<FavoriteDoctorsEntity> getFavDocsByDept(FavoriteDoctorsEntity favDoc) {
		logger.trace("" + favDoc.getUserId());
		return mfrg002Mapper.getFavDocsByDept(favDoc);
	}

	/**
	 * 医生收藏 存入DB。
	 * 
	 * @param favDoc
	 *            收藏医生信息
	 * @return 插入DB件数
	 */
	public int insertFavDoctor(FavoriteDoctorsEntity favDoc) {
		logger.trace("" + favDoc.getUserId());
		return mfrg002Mapper.insertFavDoctor(favDoc);
	}

	/**
	 * 删除医生收藏 删除DB。
	 * 
	 * @param favDoc
	 *            收藏医生信息
	 * @return 删除DB件数
	 */
	public int deleteByPrimaryKey(FavoriteDoctorsEntity favDoc) {
		logger.trace("" + favDoc.getUserId());
		return mfrg002Mapper.deleteByPrimaryKey(favDoc);
	}

}
