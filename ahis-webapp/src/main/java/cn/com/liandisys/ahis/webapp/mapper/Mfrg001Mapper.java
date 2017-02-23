package cn.com.liandisys.ahis.webapp.mapper;

import java.util.List;

import cn.com.liandisys.ahis.webapp.dto.DepartmentBasicEntity;

public interface Mfrg001Mapper {

	List<DepartmentBasicEntity> getDeptListByHospital(String hospitalCode);

	int insertDept(DepartmentBasicEntity deptItem);
	
	int deleteAllDept();

}
