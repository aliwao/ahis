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
import cn.com.liandisys.ahis.webapp.utils.AhisCommonUtil;

@Service
@Transactional
public class Mplg002Service extends AbstractAhisService<Mplg002Form> {

	@Autowired
	private UserLoginMapper userLoginMapper;
	
	@Autowired
	private UserInfoMapper userInfoMapper;

	public void insert(Mplg002Form f) {
		UserLoginEntity userLoginEntity = new UserLoginEntity();
		userLoginEntity.setMobileNo(f.getTelno());
		userLoginEntity.setName(f.getUsername());
		userLoginEntity.setPassword(f.getPasswd());
		userLoginMapper.insertSelective(userLoginEntity);

		UserInfoEntity userInfoEntity = new UserInfoEntity();
		userInfoEntity.setUserid(Long.valueOf(AhisCommonUtil.getCurrentUserInfo().getUserID()));
		userInfoEntity.setShenfenzhenghao(f.getSfzhaoma());
		userInfoMapper.insertSelective(userInfoEntity);

		setUserinfoSession(userLoginEntity);
	}

	private void setUserinfoSession(UserLoginEntity userLoginEntity) {
		LoginUserInfo userinfo = new LoginUserInfo();
		BeanUtils.copyProperties(userLoginEntity, userinfo);
		SessionService.setAttribute(AhisConstants.SESSION_KEY_USERINFO, userinfo);
	}
}
