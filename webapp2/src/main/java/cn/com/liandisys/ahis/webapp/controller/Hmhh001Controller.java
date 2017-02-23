package cn.com.liandisys.ahis.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisController;
import cn.com.liandisys.ahis.webapp.form.Hmhh001Form;

@Controller
@RequestMapping("g/hmhh001/*")
public class Hmhh001Controller extends AbstractAhisController<Hmhh001Form> {

}
