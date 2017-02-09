package cn.com.liandisys.ahis.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.liandisys.ahis.webapp.form.Mfrg005Form;
import cn.com.liandisys.ahis.webapp.mapper.Mfrg004Mapper;

@Service
public class Mfrg005Service {
	@Autowired
	private Mfrg004Mapper mfrg004Mapper;

	public void updateStatus(Mfrg005Form mfrg005Form,String status) {
		mfrg004Mapper.updateStatusByKey(mfrg005Form.getUserId(), mfrg005Form.getPsOrdNum(), mfrg005Form.getHisOrdNum(),status);
	}
}
