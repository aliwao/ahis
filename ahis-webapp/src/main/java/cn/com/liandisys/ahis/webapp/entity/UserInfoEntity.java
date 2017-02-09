package cn.com.liandisys.ahis.webapp.entity;

import java.io.Serializable;
import java.util.Date;

public class UserInfoEntity implements Serializable {
    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8413503045362807025L;

	/**
    * 用户ID
    */
    private Long userid;

    /**
    * 身份证号
    */
    private String shenfenzhenghao;

    /**
    * 医保卡号
    */
    private String yibaokahao;

    /**
    * 住址
    */
    private String address;

    /**
    * 就诊卡号
    */
    private String jzcardno;

    /**
    * 姓名
    */
    private String username;

    /**
    * 出生日期
    */
    private Date birthdate;

    /**
    * 性别
    */
    private String sex;

    /**
    * 职业
    */
    private String zhiye;

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getShenfenzhenghao() {
        return shenfenzhenghao;
    }

    public void setShenfenzhenghao(String shenfenzhenghao) {
        this.shenfenzhenghao = shenfenzhenghao;
    }

    public String getYibaokahao() {
        return yibaokahao;
    }

    public void setYibaokahao(String yibaokahao) {
        this.yibaokahao = yibaokahao;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJzcardno() {
        return jzcardno;
    }

    public void setJzcardno(String jzcardno) {
        this.jzcardno = jzcardno;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getZhiye() {
        return zhiye;
    }

    public void setZhiye(String zhiye) {
        this.zhiye = zhiye;
    }
}