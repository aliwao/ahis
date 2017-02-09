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

import cn.com.liandisys.ahis.webapp.his.HisHttpJson;
import cn.com.liandisys.ahis.webapp.his.entity.response.HospitalDeptItem;
import cn.com.liandisys.ahis.webapp.his.entity.response.HospitalDeptResponse;
import net.sf.json.JSONObject;

/**
 * 选择科室页面Service。
 * 
 * @author xuyue
 * @version 1.0
 */
@Service
@Transactional
public class Mfrg001Service {

	/**
	 * 科室信息查询mock请求。
	 * 
	 * @return 科室信息
	 * @throws UnsupportedEncodingException 
	 * @throws JAXBException
	 * @throws IOException 
	 * @throws ParseException 
	 */
	@RequestMapping
	public List<HospitalDeptItem> getDeptItemList() throws UnsupportedEncodingException, JAXBException {
//		HospitalDeptRequest requestEntity = new HospitalDeptRequest();
//		HospitalDeptResponse respone = HisHttpClient.executeHisApi("/his/hospital-dept", requestEntity,
//				HospitalDeptRequest.class, HospitalDeptResponse.class);
		JSONObject json = HisHttpJson.executeHisApi("hospital-dept", new JSONObject());
		HospitalDeptResponse respone = HisHttpJson.convJsonToBean(json, HospitalDeptResponse.class);
		if (respone.getItemList() != null) {
			return respone.getItemList();
		}
		return new ArrayList<>();
	}

}
