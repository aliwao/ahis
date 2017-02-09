package cn.com.liandisys.ahis.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisController;
import cn.com.liandisys.ahis.webapp.form.Mfih005Form;

/**
 * 账单一览页面控制器。
 * 
 * @author xuyue
 * @version 1.0
 */
@Controller
@RequestMapping("g/mfih005/*")
public class Mfih005Controller extends AbstractAhisController<Mfih005Form> {

}
