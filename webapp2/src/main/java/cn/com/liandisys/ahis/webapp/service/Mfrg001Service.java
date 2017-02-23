package cn.com.liandisys.ahis.webapp.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.apache.http.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.liandisys.ahis.webapp.dto.DepartmentBasicEntity;
import cn.com.liandisys.ahis.webapp.his.entity.request.base.DeptBaseHisRequest;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.DeptBaseHisResponse;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.item.DeptBaseItem;
import cn.com.liandisys.ahis.webapp.his.factory.DeptHisExecuteLogicFactory;
import cn.com.liandisys.ahis.webapp.his.logic.base.AbstractDeptHisExecuteLogic;
import cn.com.liandisys.ahis.webapp.mapper.Mfrg001Mapper;

/**
 * 选择科室页面Service。
 * 
 * @author xuyue
 * @version 1.0
 */
@Service
@Transactional
public class Mfrg001Service {

	@Autowired
	private Mfrg001Mapper mfrg001Mapper;

	@Autowired
	private DeptHisExecuteLogicFactory deptHisExecuteLogicFactory;

	/**
	 * 无锡三院 科室信息查询mock请求。
	 * 
	 * @return 科室信息
	 * @throws UnsupportedEncodingException
	 * @throws JAXBException
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping
	public List<DeptBaseItem> getWx3yDeptItemList() {
		AbstractDeptHisExecuteLogic logic = deptHisExecuteLogicFactory.getLogic();
		DeptBaseHisRequest request = new DeptBaseHisRequest();
		// request.setDeptCode("0001");
		DeptBaseHisResponse respone = logic.execute(request);
		if (respone.getItemList() != null) {
			return respone.getItemList();
		}
		return new ArrayList<>();
	}

	/**
	 * 获取科室信息表所有数据。
	 * 
	 * @return 科室信息List
	 */
	public List<DepartmentBasicEntity> getDBDeptListByHospital(String hospitalCode) {
		return mfrg001Mapper.getDeptListByHospital(hospitalCode);
	}

	/**
	 * 科室信息插入DB
	 * 
	 * @param dept
	 *            科室信息
	 * @return 插入个数
	 */
	public int insertDept(DeptBaseItem dept) {
		DepartmentBasicEntity entity = new DepartmentBasicEntity();
		entity.setParentCode(dept.getParentDeptCode());
		entity.setDepartmentCode(dept.getDeptCode());
		entity.setDepartmentName(dept.getDeptName());
		entity.setHasChild(dept.getHasChild());
		entity.setHospitalCode(dept.getHospitalCode());
		entity.setDepartmentDescription(dept.getDeptDescription());
		return mfrg001Mapper.insertDept(entity);
	}

	/**
	 * 清空科室信息表。
	 * 
	 * @return 删除个数
	 */
	public int delAllDept() {
		return mfrg001Mapper.deleteAllDept();
	}

}
