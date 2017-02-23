package cn.com.liandisys.ahis.webapp.mapper;

import java.util.List;

import cn.com.liandisys.ahis.webapp.dto.DoctorBasicInfoDto;
import cn.com.liandisys.ahis.webapp.entity.DoctorBasicInfoEntity;
import cn.com.liandisys.ahis.webapp.entity.FavoriteDoctorsEntity;

public interface Mfrg002Mapper {

	List<DoctorBasicInfoDto> getDeptDoctors(DoctorBasicInfoEntity doctorItem);

	int insertDoctor(DoctorBasicInfoDto doctorItem);

	int deleteAllDoctor();

	FavoriteDoctorsEntity getFavDocByPrimaryKey(FavoriteDoctorsEntity card);
	
	List<FavoriteDoctorsEntity> getFavDocsByDept(FavoriteDoctorsEntity card);

	List<FavoriteDoctorsEntity> getFavDocByUserId(Integer userId);

	int insertFavDoctor(FavoriteDoctorsEntity card);

	int deleteByPrimaryKey(FavoriteDoctorsEntity card);

}
