package cn.com.liandisys.ahis.webapp.mapper;

import org.apache.ibatis.annotations.Param;

import cn.com.liandisys.ahis.webapp.entity.AppointmentOrderEntity;

public interface Mfrg004Mapper {

	int insertAppointOrder(AppointmentOrderEntity entity);

	int getOrderNo();

	void updateStatusByKey(@Param("userId") long userId, @Param("psOrdNum") String psOrdNum,
			@Param("hisOrdNum") String hisOrdNum,@Param("status") String status);
}
