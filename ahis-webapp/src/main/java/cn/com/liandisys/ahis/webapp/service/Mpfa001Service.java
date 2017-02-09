package cn.com.liandisys.ahis.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisService;
import cn.com.liandisys.ahis.webapp.dto.LoginUserInfo;
import cn.com.liandisys.ahis.webapp.entity.FavoriteDoctorsEntity;
import cn.com.liandisys.ahis.webapp.form.Mpfa001Form;
import cn.com.liandisys.ahis.webapp.mapper.Mfrg002Mapper;
import cn.com.liandisys.ahis.webapp.utils.AhisCommonUtil;

@Service
@Transactional
public class Mpfa001Service extends AbstractAhisService<Mpfa001Form> {

	@Autowired
	private Mfrg002Mapper mfrg002Mapper;

    public void initload(Mpfa001Form f){

        LoginUserInfo userinfo = AhisCommonUtil.getCurrentUserInfo();

        List<FavoriteDoctorsEntity> favDocslist = mfrg002Mapper.getFavDocByUserId(userinfo.getUserID());

        f.setFavDocslist(favDocslist);
	}

}
