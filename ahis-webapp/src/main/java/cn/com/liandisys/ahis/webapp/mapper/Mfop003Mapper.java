package cn.com.liandisys.ahis.webapp.mapper;

import cn.com.liandisys.ahis.webapp.entity.HospitalOrderEntity;

public interface Mfop003Mapper {

	int insert(HospitalOrderEntity hisOrd);
	
	int select(HospitalOrderEntity hisOrd);
}
