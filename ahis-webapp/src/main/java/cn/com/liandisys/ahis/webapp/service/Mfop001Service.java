package cn.com.liandisys.ahis.webapp.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.liandisys.ahis.webapp.entity.HospitalOrderEntity;
import cn.com.liandisys.ahis.webapp.mapper.Mfop001Mapper;

@Service
public class Mfop001Service {

	@Autowired
	private Mfop001Mapper mfop001Mapper;

	/**
	 * 已支付一览画面表示data取得。
	 * 
	 * @param userId
	 * @return List<HospitalOrderEntity>
	 */
	public List<HospitalOrderEntity> getHasPaid(int userId) {

		return mfop001Mapper.getHasPaid(userId);
	}

}
