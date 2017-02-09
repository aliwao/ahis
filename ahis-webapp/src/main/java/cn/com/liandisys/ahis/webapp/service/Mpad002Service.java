package cn.com.liandisys.ahis.webapp.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisService;
import cn.com.liandisys.ahis.webapp.dto.LoginUserInfo;
import cn.com.liandisys.ahis.webapp.entity.SiteInfoEntity;
import cn.com.liandisys.ahis.webapp.form.Mpad002Form;
import cn.com.liandisys.ahis.webapp.mapper.SiteInfoMapper;
import cn.com.liandisys.ahis.webapp.utils.AhisCommonUtil;

@Service
@Transactional
public class Mpad002Service extends AbstractAhisService<Mpad002Form> {

	@Autowired
	private SiteInfoMapper siteInfoMapper;

    public void initload(Mpad002Form f){

        SiteInfoEntity siteinfo = siteInfoMapper.getByPrimaryKey(f.getSiteid());
        if(siteinfo != null){
            BeanUtils.copyProperties(siteinfo, f);
        }
	}

    public void save(Mpad002Form f){

        LoginUserInfo userinfo = AhisCommonUtil.getCurrentUserInfo();
        SiteInfoEntity siteinfo = new SiteInfoEntity();
        BeanUtils.copyProperties(f, siteinfo);
        siteinfo.setUserID(userinfo.getUserID());
        if(f.getSiteid() == null || f.getSiteid().intValue() == 0){
            siteinfo.setSiteid(null);
            siteInfoMapper.insertSelective(siteinfo);
        }
        else {
            siteInfoMapper.updateByPrimaryKeySelective(siteinfo);
        }
	}

    public void delete(Mpad002Form f){

        LoginUserInfo userinfo = AhisCommonUtil.getCurrentUserInfo();
        SiteInfoEntity siteinfo = new SiteInfoEntity();
        siteinfo.setSiteid(f.getSiteid());
        siteinfo.setUserID(userinfo.getUserID());
        if(f.getSiteid() == null || f.getSiteid().intValue() == 0){
        }
        else {
            siteInfoMapper.deleteByPrimaryKey(siteinfo);
        }
	}
}
