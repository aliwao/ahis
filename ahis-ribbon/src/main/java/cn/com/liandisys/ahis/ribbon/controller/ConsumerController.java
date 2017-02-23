package cn.com.liandisys.ahis.ribbon.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return restTemplate.getForEntity("http://AHIS-WEBAPP/cloud/add?a=1&b=2", String.class).getBody();
	}

	@RequestMapping("/")
	public String index(@ModelAttribute Object f, HttpServletRequest req) {
		return restTemplate.getForEntity("http://AHIS-WEBAPP/", String.class).getBody();
	}

}
