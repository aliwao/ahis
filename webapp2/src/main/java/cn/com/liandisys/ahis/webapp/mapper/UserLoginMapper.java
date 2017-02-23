package cn.com.liandisys.ahis.webapp.mapper;

import java.util.List;

import cn.com.liandisys.ahis.webapp.entity.UserLoginEntity;

public interface UserLoginMapper {

	List<UserLoginEntity> getAll();
	
	UserLoginEntity getByMobileNo(String mobileNo);
	
	Integer getUserIdByMobileNo(String mobileNo);
	
	int insert(UserLoginEntity userLoginEntity);
	
	int insertSelective(UserLoginEntity userLoginEntity);
	
	int updateByPrimaryKeySelective(UserLoginEntity userLoginEntity);
}
