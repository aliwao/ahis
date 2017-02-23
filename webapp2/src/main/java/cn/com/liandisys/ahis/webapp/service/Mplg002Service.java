package cn.com.liandisys.ahis.webapp.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisService;
import cn.com.liandisys.ahis.webapp.constants.AhisConstants;
import cn.com.liandisys.ahis.webapp.dto.LoginUserInfo;
import cn.com.liandisys.ahis.webapp.entity.UserInfoEntity;
import cn.com.liandisys.ahis.webapp.entity.UserLoginEntity;
import cn.com.liandisys.ahis.webapp.form.Mplg002Form;
import cn.com.liandisys.ahis.webapp.mapper.UserInfoMapper;
import cn.com.liandisys.ahis.webapp.mapper.UserLoginMapper;

@Service
@Transactional
public class Mplg002Service extends AbstractAhisService<Mplg002Form> {

	@Autowired
	private UserLoginMapper userLoginMapper;
	
	@Autowired
	private UserInfoMapper userInfoMapper;

	public boolean verifyTelno(Mplg002Form f) {
		UserLoginEntity entity = userLoginMapper.getByMobileNo(f.getTelno());
		if(entity != null){
			return false;
		}
		return true;
	}

	public boolean verifyIdentityCardNo(Mplg002Form f) {
		UserInfoEntity entity = userInfoMapper.selectByIdentityCardNo(f.getSfzhaoma());
		if(entity != null){
			return false;
		}
		return true;
	}

	public void insert(Mplg002Form f) {

		UserLoginEntity userLoginEntity = new UserLoginEntity();
		userLoginEntity.setMobileNo(f.getTelno());
		userLoginEntity.setPassword(f.getPassword());
		userLoginMapper.insertSelective(userLoginEntity);

		userLoginEntity = userLoginMapper.getByMobileNo(f.getTelno());

		UserInfoEntity userInfoEntity = new UserInfoEntity();
		userInfoEntity.setUserID(userLoginEntity.getUserID());
		userInfoEntity.setIdentityCardNo(f.getSfzhaoma());
		userInfoEntity.setFullName(f.getUsername());
		userInfoMapper.insertSelective(userInfoEntity);

		setUserinfoSession(userLoginEntity, userInfoEntity);
	}

	private void setUserinfoSession(UserLoginEntity userLoginEntity, UserInfoEntity userInfoEntity) {
		LoginUserInfo userinfo = new LoginUserInfo();
		BeanUtils.copyProperties(userLoginEntity, userinfo);
		BeanUtils.copyProperties(userInfoEntity, userinfo);
		SessionService.setAttribute(AhisConstants.SESSION_KEY_USERINFO, userinfo);
	}

}
