package cn.com.liandisys.ahis.webapp.controller;

import java.io.UnsupportedEncodingException;

import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.liandisys.ahis.webapp.his.HisHttpClient;
import cn.com.liandisys.ahis.webapp.his.entity.request.HospitalDeptRequest;
import cn.com.liandisys.ahis.webapp.his.entity.response.HospitalDeptResponse;

@RestController
@RequestMapping("/hello")
public class HelloController {

	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

	@RequestMapping
	String hello() throws UnsupportedEncodingException, JAXBException {
		HospitalDeptRequest requestEntity = new HospitalDeptRequest();
		requestEntity.setDeptCode("1234");
		HospitalDeptResponse respone = HisHttpClient.executeHisApi("/his/hospital-dept", requestEntity,
				HospitalDeptRequest.class, HospitalDeptResponse.class);
		logger.debug(respone.getResultCode());
		logger.debug(respone.getResultMessage());
		respone.getItemList().forEach(item -> {
			logger.trace(item.getDeptCode());
			logger.trace(item.getDeptName());
		});
		return respone.getResultCode();
	}
}
