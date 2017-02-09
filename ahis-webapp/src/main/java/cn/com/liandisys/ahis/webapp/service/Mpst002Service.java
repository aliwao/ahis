package cn.com.liandisys.ahis.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisService;
import cn.com.liandisys.ahis.webapp.constants.AhisConstants;
import cn.com.liandisys.ahis.webapp.dto.LoginUserInfo;
import cn.com.liandisys.ahis.webapp.entity.UserLoginEntity;
import cn.com.liandisys.ahis.webapp.form.Mpst002Form;
import cn.com.liandisys.ahis.webapp.mapper.UserLoginMapper;
import cn.com.liandisys.ahis.webapp.utils.AhisCommonUtil;

@Service
@Transactional
public class Mpst002Service extends AbstractAhisService<Mpst002Form> {

	@Autowired
	private UserLoginMapper userLoginMapper;

    public void initload(Mpst002Form f){
        f.setMobileNo(AhisCommonUtil.getCurrentUsernameTelno());
	}

    public void save(Mpst002Form f){
        String oldMobileNo = AhisCommonUtil.getCurrentUsernameTelno();
        UserLoginEntity userloginInfo = userLoginMapper.getByMobileNo(oldMobileNo);
        int userid = userloginInfo.getUserID();

        // 手机号码更新
        UserLoginEntity userlogin = new UserLoginEntity();
        userlogin.setUserID(userid);
        userlogin.setMobileNo(f.getMobileNo());
        userLoginMapper.updateByPrimaryKeySelective(userlogin);

        resetUserinfoSession(f.getMobileNo());
    }

    private void resetUserinfoSession(String mobileNo) {
		LoginUserInfo userinfo = AhisCommonUtil.getCurrentUserInfo();
		userinfo.setMobileNo(mobileNo);
		SessionService.setAttribute(AhisConstants.SESSION_KEY_USERINFO, userinfo);
	}
}
