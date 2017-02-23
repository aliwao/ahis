package cn.com.liandisys.ahis.webapp.mapper;

import org.apache.ibatis.annotations.Param;

import cn.com.liandisys.ahis.webapp.entity.RegisterHistoryEntity;

public interface RegisterHistoryMapper {

	void insertRegisterHistory(RegisterHistoryEntity entity);

	RegisterHistoryEntity getRegisterInfoByKey(String registerNo);

	void updateStatusByKey(@Param("registerNo")String registerNo,@Param("registerStatus")String registerStatus);
}
