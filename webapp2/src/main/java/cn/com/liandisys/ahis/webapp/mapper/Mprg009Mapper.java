package cn.com.liandisys.ahis.webapp.mapper;

import java.util.List;

import cn.com.liandisys.ahis.webapp.entity.RegisterRelateEntity;

public interface Mprg009Mapper {
	List<RegisterRelateEntity> selectRegisterByUserID(long userID);
}
