package cn.com.liandisys.ahis.webapp.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 医保卡绑定信息Entity。
 * 
 * @author xuyue
 * @version 1.0
 */
public class MedicareCardInfoEntity implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -683183010888965391L;

	/**
	 * 用户ID
	 */
	private Long userId;

    /**
	 * 医保卡号
	 */
    private String yibaokahao;

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

    public String getYibaokahao() {
        return yibaokahao;
    }

    public void setYibaokahao(String yibaokahao) {
        this.yibaokahao = yibaokahao;
    }

	public Timestamp getInsertTimeStamp() {
		return insertTimeStamp;
	}

	public void setInsertTimeStamp(Timestamp insertTimeStamp) {
		this.insertTimeStamp = insertTimeStamp;
	}

}