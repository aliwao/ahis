package cn.com.liandisys.ahis.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisService;
import cn.com.liandisys.ahis.webapp.dto.LoginUserInfo;
import cn.com.liandisys.ahis.webapp.entity.SiteInfoEntity;
import cn.com.liandisys.ahis.webapp.form.Mpad001Form;
import cn.com.liandisys.ahis.webapp.mapper.SiteInfoMapper;
import cn.com.liandisys.ahis.webapp.utils.AhisCommonUtil;

@Service
@Transactional
public class Mpad001Service extends AbstractAhisService<Mpad001Form> {

	@Autowired
	private SiteInfoMapper siteInfoMapper;

    public void initload(Mpad001Form f){

        LoginUserInfo userinfo = AhisCommonUtil.getCurrentUserInfo();

        List<SiteInfoEntity> sitelist = siteInfoMapper.getAllByUserId(userinfo.getUserID());

        f.setSitelist(sitelist);
	}

}
