package cn.com.liandisys.ahis.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisController;
import cn.com.liandisys.ahis.webapp.form.Mfih007Form;

/**
 * 出院结算页面控制器。
 * 
 * @author xuyue
 * @version 1.0
 */
@Controller
@RequestMapping("g/mfih007/*")
public class Mfih007Controller extends AbstractAhisController<Mfih007Form> {

}
