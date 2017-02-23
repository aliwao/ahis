package cn.com.liandisys.ahis.webapp.mapper;

import cn.com.liandisys.ahis.webapp.entity.UserInfoEntity;

public interface UserInfoMapper {

    int deleteByPrimaryKey(Long userid);

    int insert(UserInfoEntity record);

    int insertSelective(UserInfoEntity record);

    UserInfoEntity selectByPrimaryKey(Long userid);

    UserInfoEntity selectByIdentityCardNo(String identityCardNo);

    int updateByPrimaryKeySelective(UserInfoEntity record);

    int updateByPrimaryKey(UserInfoEntity record);
}