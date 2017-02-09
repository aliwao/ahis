package cn.com.liandisys.ahis.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisService;
import cn.com.liandisys.ahis.webapp.dto.LoginUserInfo;
import cn.com.liandisys.ahis.webapp.entity.UserInfoEntity;
import cn.com.liandisys.ahis.webapp.entity.UserLoginEntity;
import cn.com.liandisys.ahis.webapp.form.Mplg003Form;
import cn.com.liandisys.ahis.webapp.mapper.UserInfoMapper;
import cn.com.liandisys.ahis.webapp.mapper.UserLoginMapper;
import cn.com.liandisys.ahis.webapp.utils.AhisCommonUtil;

@Service
@Transactional
public class Mplg003Service extends AbstractAhisService<Mplg003Form> {

	@Autowired
	private UserLoginMapper userLoginMapper;
	
	@Autowired
	private UserInfoMapper userInfoMapper;

    public void initload(Mplg003Form f){

        LoginUserInfo userlogin = AhisCommonUtil.getCurrentUserInfo();

        UserInfoEntity userInfo = userInfoMapper.selectByPrimaryKey(Long.valueOf(userlogin.getUserID()));

        f.setUsername(userlogin.getName());
        if(userInfo != null){
            f.setSfzhao(userInfo.getShenfenzhenghao());
            f.setBirthDate(userInfo.getBirthdate());
            f.setSex(userInfo.getSex());
            f.setAddress(userInfo.getAddress());
            f.setZhiye(userInfo.getZhiye());
        }

	}

    public void save(Mplg003Form f){
        int userid = AhisCommonUtil.getCurrentUserInfo().getUserID();

        UserInfoEntity userInfo = userInfoMapper.selectByPrimaryKey(Long.valueOf(userid));

        UserLoginEntity userlogin = new UserLoginEntity();
        userlogin.setUserID(userid);
        userlogin.setName(f.getUsername());
        userLoginMapper.updateByPrimaryKeySelective(userlogin);

        if(userInfo != null){
            userInfo.setUsername(f.getUsername());
            userInfo.setBirthdate(f.getBirthDate());
            userInfo.setSex(f.getSex());
            userInfo.setAddress(f.getAddress());
            userInfo.setZhiye(f.getZhiye());
            userInfoMapper.updateByPrimaryKeySelective(userInfo);
        }
        else {
            userInfo = new UserInfoEntity();
            userInfo.setUserid(Long.valueOf(userid));
            userInfo.setUsername(f.getUsername());
            userInfo.setBirthdate(f.getBirthDate());
            userInfo.setSex(f.getSex());
            userInfo.setAddress(f.getAddress());
            userInfo.setZhiye(f.getZhiye());
            userInfoMapper.insertSelective(userInfo);
        }

	}
}
