package cn.com.liandisys.ahis.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisController;
import cn.com.liandisys.ahis.webapp.form.Emem001Form;

@Controller
@RequestMapping("g/emem001/*")
public class Emem001Controller extends AbstractAhisController<Emem001Form> {

}
