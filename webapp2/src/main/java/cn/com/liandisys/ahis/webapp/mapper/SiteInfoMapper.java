package cn.com.liandisys.ahis.webapp.mapper;

import java.util.List;

import cn.com.liandisys.ahis.webapp.entity.SiteInfoEntity;

public interface SiteInfoMapper {

	List<SiteInfoEntity> getAllByUserId(Integer userid);

	SiteInfoEntity getByPrimaryKey(Integer siteid);

	int insert(SiteInfoEntity siteInfoEntity);
	
	int insertSelective(SiteInfoEntity siteInfoEntity);
	
	int updateByPrimaryKeySelective(SiteInfoEntity siteInfoEntity);
	
	int deleteByPrimaryKey(SiteInfoEntity siteInfoEntity);
}
