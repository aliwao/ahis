package cn.com.liandisys.ahis.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisController;
import cn.com.liandisys.ahis.webapp.form.Hphp001Form;

@Controller
@RequestMapping("/g/hphp001/*")
public class Hphp001Controller extends AbstractAhisController<Hphp001Form> {

}
