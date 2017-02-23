package cn.com.liandisys.ahis.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisService;
import cn.com.liandisys.ahis.webapp.constants.AhisConstants;
import cn.com.liandisys.ahis.webapp.dto.LoginUserInfo;
import cn.com.liandisys.ahis.webapp.entity.UserLoginEntity;
import cn.com.liandisys.ahis.webapp.form.Mpst003Form;
import cn.com.liandisys.ahis.webapp.mapper.UserLoginMapper;
import cn.com.liandisys.ahis.webapp.utils.AhisCommonUtil;

@Service
@Transactional
public class Mpst003Service extends AbstractAhisService<Mpst003Form> {

	@Autowired
	private UserLoginMapper userLoginMapper;

    /**
     * 验证密码是否正确
     * @param f
     * @return
     */
    public boolean checkPasswd(Mpst003Form f){
        LoginUserInfo userinfo = AhisCommonUtil.getCurrentUserInfo();
        if(!f.getOldpasswd().equals(userinfo.getPassword())){
            return false;
        }
        return true;
    }

    public void save(Mpst003Form f){
        String oldMobileNo = AhisCommonUtil.getCurrentUsernameTelno();
        UserLoginEntity userloginInfo = userLoginMapper.getByMobileNo(oldMobileNo);
        int userid = userloginInfo.getUserID();

        // 登录密码更新
        UserLoginEntity userlogin = new UserLoginEntity();
        userlogin.setUserID(userid);
        userlogin.setPassword(f.getPasswd());
        userLoginMapper.updateByPrimaryKeySelective(userlogin);

        resetUserinfoSession(f.getPasswd());
    }

    private void resetUserinfoSession(String passwd) {
		LoginUserInfo userinfo = AhisCommonUtil.getCurrentUserInfo();
		userinfo.setPassword(passwd);
		SessionService.setAttribute(AhisConstants.SESSION_KEY_USERINFO, userinfo);
	}
}
