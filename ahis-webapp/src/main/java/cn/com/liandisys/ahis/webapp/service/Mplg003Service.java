package cn.com.liandisys.ahis.webapp.service;

import java.io.IOException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisService;
import cn.com.liandisys.ahis.webapp.constants.AhisConstants;
import cn.com.liandisys.ahis.webapp.dto.LoginUserInfo;
import cn.com.liandisys.ahis.webapp.entity.UserInfoEntity;
import cn.com.liandisys.ahis.webapp.form.Mplg003Form;
import cn.com.liandisys.ahis.webapp.mapper.UserInfoMapper;
import cn.com.liandisys.ahis.webapp.utils.AhisCommonUtil;

@Service
@Transactional
public class Mplg003Service extends AbstractAhisService<Mplg003Form> {

	@Autowired
	private UserInfoMapper userInfoMapper;

    public void initload(Mplg003Form f){

        LoginUserInfo userlogin = AhisCommonUtil.getCurrentUserInfo();

        UserInfoEntity userInfo = userInfoMapper.selectByPrimaryKey(Long.valueOf(userlogin.getUserID()));

        f.setUsername(userlogin.getFullName());
        if(userInfo != null){
            f.setIdentityCardNo(userInfo.getIdentityCardNo());
            f.setBirthDate(userInfo.getBirthDate());
            f.setSex(userInfo.getSex());
            f.setAddress(userInfo.getAddress());
            f.setOccupation(userInfo.getOccupation());
        }

	}

	public void save(Mplg003Form f){
		int userid = AhisCommonUtil.getCurrentUserInfo().getUserID();

		UserInfoEntity userInfo = userInfoMapper.selectByPrimaryKey(Long.valueOf(userid));

		if(userInfo != null){
			userInfo.setFullName(f.getUsername());
			try {
				if(f.getPortrait() != null && !f.getPortrait().isEmpty()) {
					userInfo.setPortrait(f.getPortrait().getBytes());
				}
				else {
					userInfo.setPortrait(null);
				}
			} catch (IOException e) {
				userInfo.setPortrait(null);
			}
            userInfo.setBirthDate(f.getBirthDate());
            userInfo.setSex(f.getSex());
            userInfo.setAddress(f.getAddress());
            userInfo.setOccupation(f.getOccupation());
            userInfoMapper.updateByPrimaryKeySelective(userInfo);
        }
        else {
            userInfo = new UserInfoEntity();
            userInfo.setUserID(userid);
            userInfo.setFullName(f.getUsername());
            try {
            	if(f.getPortrait() != null && !f.getPortrait().isEmpty()) {
					userInfo.setPortrait(f.getPortrait().getBytes());
				}
				else {
					userInfo.setPortrait(null);
				}
			} catch (IOException e) {
				userInfo.setPortrait(null);
			}
            userInfo.setBirthDate(f.getBirthDate());
            userInfo.setSex(f.getSex());
            userInfo.setAddress(f.getAddress());
            userInfo.setOccupation(f.getOccupation());
            userInfoMapper.insertSelective(userInfo);
        }
        setUserinfoSession(userInfo);
	}

	private void setUserinfoSession(UserInfoEntity userInfoEntity) {
		LoginUserInfo userinfo = new LoginUserInfo();
		BeanUtils.copyProperties(userInfoEntity, userinfo);
		SessionService.setAttribute(AhisConstants.SESSION_KEY_USERINFO, userinfo);
	}
}
