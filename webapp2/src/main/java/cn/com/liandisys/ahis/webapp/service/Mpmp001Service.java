package cn.com.liandisys.ahis.webapp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisService;
import cn.com.liandisys.ahis.webapp.dto.LoginUserInfo;
import cn.com.liandisys.ahis.webapp.form.Mpmp001Form;
import cn.com.liandisys.ahis.webapp.utils.AhisCommonUtil;

@Service
@Transactional
public class Mpmp001Service extends AbstractAhisService<Mpmp001Form> {

	public void index(Mpmp001Form f) {

		LoginUserInfo userinfo = AhisCommonUtil.getCurrentUserInfo();
		if(userinfo != null) {
			f.setUsername(userinfo.getFullName());
		}

	}
}
