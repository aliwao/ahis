package cn.com.liandisys.ahis.webapp.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.apache.http.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;

import cn.com.liandisys.ahis.webapp.his.HisHttpJson;
import cn.com.liandisys.ahis.webapp.his.entity.response.HospitalizationFeeResponse;
import cn.com.liandisys.ahis.webapp.his.entity.response.HospitalizationRecordItem;
import cn.com.liandisys.ahis.webapp.his.entity.response.HospitalizationRecordResponse;

/**
 * 住院服务Service。
 * 
 * @author xuyue
 * @version 1.0
 */
@Service
@Transactional
public class Mfis008Service {

	/**
	 * 无锡三院 住院记录查询mock请求。
	 * 
	 * @param request
	 *            诊疗卡类型、诊疗卡号
	 * @return 科室信息
	 * @throws UnsupportedEncodingException
	 * @throws JAXBException
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping
	public List<HospitalizationRecordItem> getWx3yHospitalizationRecord(JSONObject request) {
		JSONObject json = HisHttpJson.executeHisApi("ZYJLCX", request);
		HospitalizationRecordResponse respone = HisHttpJson.convJsonToBean(json, HospitalizationRecordResponse.class);

		if (respone.getItemList() != null) {
			return respone.getItemList();
		}
		return new ArrayList<>();
	}

	/**
	 * 无锡三院 住院费用清单查询 mock请求。
	 * 
	 * @param request
	 *            诊疗卡类型、诊疗卡号、住院号、清单开始日期、清单结束日期
	 * @return 住院费用清单
	 * @throws UnsupportedEncodingException
	 * @throws JAXBException
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping
	public HospitalizationFeeResponse getWx3yHospitalizationFee(JSONObject request) throws UnsupportedEncodingException, JAXBException {
		JSONObject json = HisHttpJson.executeHisApi("ZYFYQDCX", request);
		return HisHttpJson.convJsonToBean(json, HospitalizationFeeResponse.class);

	}

}
