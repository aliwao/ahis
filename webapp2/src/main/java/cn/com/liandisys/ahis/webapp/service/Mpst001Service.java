package cn.com.liandisys.ahis.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisService;
import cn.com.liandisys.ahis.webapp.form.Mpst001Form;
import cn.com.liandisys.ahis.webapp.mapper.Mpst004Mapper;
import cn.com.liandisys.ahis.webapp.mapper.Mpst005Mapper;
import cn.com.liandisys.ahis.webapp.mapper.Mpst006Mapper;
import cn.com.liandisys.ahis.webapp.utils.AhisCommonUtil;

@Service
@Transactional
public class Mpst001Service extends AbstractAhisService<Mpst001Form> {

	@Autowired
	private Mpst004Mapper mpst004Mapper;

	@Autowired
	private Mpst005Mapper mpst005Mapper;

	@Autowired
	private Mpst006Mapper mpst006Mapper;

    /**
     * 初期数据加载
     * @param f
     */
    public void initload(Mpst001Form f){
        f.setMobileNo(AhisCommonUtil.getCurrentUsernameTelno());
	}

    /**
     * 验证某卡是否绑定
     * @param cardCd
     * @return
     */
    public String checkBinding(String cardCd){
        String result = "";
        Integer userId = AhisCommonUtil.getCurrentUserInfo().getUserID();
        // 医保卡
        if("1".equals(cardCd)){
            result = mpst004Mapper.getCardByUserId(userId);
        }
        // 就诊卡
        else if("2".equals(cardCd)){
            result = mpst005Mapper.getCardByUserId(userId);
        }
        // 银行卡
        else if("3".equals(cardCd)){
            result = String.valueOf(mpst006Mapper.getCntByUserId(userId));
        }
        return result;
	}
}
