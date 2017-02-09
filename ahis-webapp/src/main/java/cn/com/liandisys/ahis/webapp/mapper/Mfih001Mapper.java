package cn.com.liandisys.ahis.webapp.mapper;

import java.util.List;

import cn.com.liandisys.ahis.webapp.dto.PatientsHospitalizedInfo;
import cn.com.liandisys.ahis.webapp.entity.PatientsHospitalizedEntity;

public interface Mfih001Mapper {

	/**
	 * 获取用户住院信息。
	 * 
	 * @param param
	 *            检索条件（用户id, 状态flag:0:未入院，1:已在院）
	 * @return 住院信息
	 */
	PatientsHospitalizedInfo getInfoByUserIdAndStatusFlg(PatientsHospitalizedEntity param);

	/**
	 * 获取用户住院信息。
	 * 
	 * @param param
	 *            检索条件（住院单号）
	 * @return 住院信息
	 */
	PatientsHospitalizedInfo getInfoByStayNo(PatientsHospitalizedEntity param);

	/**
	 * 获取用户住院信息。（0:未入院，1:已在院，2：已出院）
	 * 
	 * @param param
	 *            检索条件（用户id）
	 * @return 住院信息
	 */
	List<PatientsHospitalizedInfo> getListByUserId(PatientsHospitalizedEntity param);

	/**
	 * 获取用户住院信息。（1:已在院，2：已出院）
	 * 
	 * @param param
	 *            检索条件（用户id）
	 * @return 住院信息
	 */
	List<PatientsHospitalizedInfo> getStayListByUserId(PatientsHospitalizedEntity param);
}
