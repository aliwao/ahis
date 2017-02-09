package cn.com.liandisys.ahis.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisController;
import cn.com.liandisys.ahis.webapp.form.Mfih006Form;

/**
 * 账单详细页面控制器。
 * 
 * @author xuyue
 * @version 1.0
 */
@Controller
@RequestMapping("g/mfih006/*")
public class Mfih006Controller extends AbstractAhisController<Mfih006Form> {

}
