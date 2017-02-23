package cn.com.liandisys.ahis.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class IndexController {
	@RequestMapping
	String index() {
		return "redirect:/g/hphp001/index";
	}
	
	@RequestMapping("info")
	String info() {
		return "index";
	}
	
	@RequestMapping("test/{name}")
	String test(@PathVariable("name")String name) {
		return name;
	}
}
