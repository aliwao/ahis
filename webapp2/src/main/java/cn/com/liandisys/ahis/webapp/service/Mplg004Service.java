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
import cn.com.liandisys.ahis.webapp.form.Mplg004Form;
import cn.com.liandisys.ahis.webapp.mapper.UserInfoMapper;
import cn.com.liandisys.ahis.webapp.mapper.UserLoginMapper;
import cn.com.liandisys.ahis.webapp.utils.AhisCommonUtil;

@Service
@Transactional
public class Mplg004Service extends AbstractAhisService<Mplg004Form> {

	@Autowired
	private UserLoginMapper userLoginMapper;

	@Autowired
	private UserInfoMapper userInfoMapper;

    public void initload(Mplg004Form f){
        f.setMobileNo(AhisCommonUtil.getCurrentUsernameTelno());
	}

	public boolean verifyTelno(Mplg004Form f) {
		UserLoginEntity entity = userLoginMapper.getByMobileNo(f.getMobileNo());
		//int myuserid = AhisCommonUtil.getCurrentUserInfo().getUserID();
		//if(entity != null && entity.getUserID() != myuserid){
		if(entity != null){
			return false;
		}
		return true;
	}

    public void save(Mplg004Form f){
        String mobileNo = f.getMobileNo();
        UserLoginEntity userloginInfo = userLoginMapper.getByMobileNo(mobileNo);
        int userid = userloginInfo.getUserID();

        // 密码更新
        userloginInfo.setPassword(f.getPassword());
        userLoginMapper.updateByPrimaryKeySelective(userloginInfo);

        UserInfoEntity userInfoEntity = userInfoMapper.selectByPrimaryKey(Long.valueOf(userid));
        setUserinfoSession(userloginInfo, userInfoEntity);
    }

	private void setUserinfoSession(UserLoginEntity userLoginEntity, UserInfoEntity userInfoEntity) {
		LoginUserInfo userinfo = new LoginUserInfo();
		BeanUtils.copyProperties(userLoginEntity, userinfo);
		BeanUtils.copyProperties(userInfoEntity, userinfo);
		SessionService.setAttribute(AhisConstants.SESSION_KEY_USERINFO, userinfo);
	}
}
