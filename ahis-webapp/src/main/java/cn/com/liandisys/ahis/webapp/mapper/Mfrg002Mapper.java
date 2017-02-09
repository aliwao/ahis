package cn.com.liandisys.ahis.webapp.mapper;

import java.util.List;

import cn.com.liandisys.ahis.webapp.entity.FavoriteDoctorsEntity;

public interface Mfrg002Mapper {

	FavoriteDoctorsEntity getFavDocByPrimaryKey(FavoriteDoctorsEntity card);
	
	List<FavoriteDoctorsEntity> getFavDocsByDept(FavoriteDoctorsEntity card);

	List<FavoriteDoctorsEntity> getFavDocByUserId(Integer userId);

	int insertFavDoctor(FavoriteDoctorsEntity card);

	int deleteByPrimaryKey(FavoriteDoctorsEntity card);

}
