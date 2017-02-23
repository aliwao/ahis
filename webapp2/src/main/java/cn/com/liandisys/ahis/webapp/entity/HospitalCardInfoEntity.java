package cn.com.liandisys.ahis.webapp.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 就诊卡绑定信息Entity。
 * 
 * @author xuyue
 * @version 1.0
 */
public class HospitalCardInfoEntity implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7666862120415219159L;

	/**
	 * 用户ID
	 */
	private Long userId;

    /**
	 * 就诊卡号
	 */
	private String jiuzhenkahao;

	/**
	 * 创建时间
	 */
	private Timestamp insertTimeStamp;


	public Long getUserId() {
		return userId;
    }

	public void setUserId(Long userId) {
		this.userId = userId;
    }

	public String getJiuzhenkahao() {
		return jiuzhenkahao;
    }

	public void setJiuzhenkahao(String jiuzhenkahao) {
		this.jiuzhenkahao = jiuzhenkahao;
    }

	public Timestamp getInsertTimeStamp() {
		return insertTimeStamp;
	}

	public void setInsertTimeStamp(Timestamp insertTimeStamp) {
		this.insertTimeStamp = insertTimeStamp;
	}

}