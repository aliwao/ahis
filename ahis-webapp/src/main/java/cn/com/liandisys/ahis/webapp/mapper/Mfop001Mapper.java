package cn.com.liandisys.ahis.webapp.mapper;

import java.util.List;

import cn.com.liandisys.ahis.webapp.entity.HospitalOrderEntity;

public interface Mfop001Mapper {

	List<HospitalOrderEntity> getHasPaid(int userId);
}
