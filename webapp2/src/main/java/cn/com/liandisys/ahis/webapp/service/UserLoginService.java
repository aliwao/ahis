package cn.com.liandisys.ahis.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.liandisys.ahis.webapp.entity.UserLoginEntity;
import cn.com.liandisys.ahis.webapp.mapper.UserLoginMapper;

@Service
public class UserLoginService {

	@Autowired
	private UserLoginMapper userLoginMapper;

	public List<UserLoginEntity> getAll() {
		return userLoginMapper.getAll();
	}

	public UserLoginEntity getByMobileNo(String mobileNo) {
		return userLoginMapper.getByMobileNo(mobileNo);
	}

	public int insert(UserLoginEntity userLoginEntity) {
		return userLoginMapper.insert(userLoginEntity);
	}

	@Transactional
	public int bulkInsert(UserLoginEntity userLoginEntity) {
		int intCnt = 0;

		for (int i = 0; i < 100; i++) {
			userLoginEntity.setUserID(userLoginEntity.getUserID() + 1);
			//userLoginEntity.setName(userLoginEntity.getName() + "1");
			userLoginMapper.insert(userLoginEntity);
		}

		return intCnt;
	}
}
