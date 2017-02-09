package cn.com.liandisys.ahis.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisController;
import cn.com.liandisys.ahis.webapp.form.Mfrg007Form;

@Controller
@RequestMapping("/m/mfrg007/*")
public class Mfrg007Controller extends AbstractAhisController<Mfrg007Form> {

}
