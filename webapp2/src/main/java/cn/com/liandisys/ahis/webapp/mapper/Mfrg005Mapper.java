package cn.com.liandisys.ahis.webapp.mapper;

import cn.com.liandisys.ahis.webapp.entity.RegisterRelateEntity;

public interface Mfrg005Mapper {

	RegisterRelateEntity selectRegisterByRegisterNo(String registerNo);
}
