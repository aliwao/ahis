package cn.com.liandisys.ahis.webapp.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisController;
import cn.com.liandisys.ahis.webapp.entity.DoctorBasicInfoEntity;
import cn.com.liandisys.ahis.webapp.entity.FavoriteDoctorsEntity;
import cn.com.liandisys.ahis.webapp.entity.RegDocInfoEntity;
import cn.com.liandisys.ahis.webapp.form.Mfrg002Form;
import cn.com.liandisys.ahis.webapp.his.entity.response.RegisterInfoItem;
import cn.com.liandisys.ahis.webapp.service.Mfrg002Service;
import cn.com.liandisys.ahis.webapp.utils.AhisCommonUtil;


/**
 * 预约挂号页面控制器。
 * 
 * @author xuyue
 * @version 1.0
 */
@Controller
public class Mfrg002Controller extends AbstractAhisController<Mfrg002Form> {

	private static String AM = "1";
	private static String PM = "2";
	private static String CANREGISTER = "1";
	private static String CANNOTREGISTER = "0";

	@Autowired
	private Mfrg002Service mfrg002Service;

	/**
	 * 画面显示（登录状态时用）。
	 * 
	 * @param mfrg002Form
	 *            画面From
	 * @return 画面url
	 */
	@RequestMapping("m/mfrg002/index")
	public String loginindex(@ModelAttribute Mfrg002Form mfrg002Form) {
		return index(mfrg002Form);
	}

	/**
	 * 画面显示。
	 * 
	 * @param mfrg002Form
	 *            画面From
	 * @return 画面url
	 * @throws JAXBException
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("g/mfrg002/index")
	public String index(@ModelAttribute Mfrg002Form mfrg002Form) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年M月d日 E");
		String regDate = mfrg002Form.getReserveDate();
		String todayDate = sdf.format(new Date());

		if (regDate == null || isDate1BeforeDate2(regDate, todayDate)) {
			// 默认挂号时间:当天 （格式：××××年×月××日 星期×）
			mfrg002Form.setTodayDate(todayDate);
			regDate = todayDate;
			mfrg002Form.setReserveDate(regDate.replace(" 月", " 一").replace("火", "二").replace("水", "三").replace("木", "四").replace("金", "五")
					.replace("土", "六"));
		}
		// 今日开始的40天内 可选择预约挂号
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		mfrg002Form.setMaxReserveDate(sdf.format(DateUtils.addDays(new Date(), 39)));

		// 预约挂号数据mock
		String year = regDate.substring(0, 4);
		String month = regDate.substring(5, regDate.indexOf("月"));
		if (month.length() == 1) {
			month = "0" + month;
		}
		String day = regDate.substring(regDate.indexOf("月") + 1, regDate.indexOf("日"));
		if (day.length() == 1) {
			day = "0" + day;
		}

		JSONObject json = new JSONObject();
		json.put("beginDate", year + "-" + month + "-" + day);
		json.put("endDate", year + "-" + month + "-" + day);
		json.put("deptCode", mfrg002Form.getDeptCode());

			List<RegisterInfoItem> regInfoList = mfrg002Service.getRegisterInfoList(json);
			List<DoctorBasicInfoEntity> docEntityList = getDocInfoList(mfrg002Form.getDeptCode());

			List<FavoriteDoctorsEntity> favDoctors = new ArrayList<>();
			if (AhisCommonUtil.getCurrentUserInfo() != null) {
				FavoriteDoctorsEntity param = new FavoriteDoctorsEntity();
				param.setUserId(new Long(AhisCommonUtil.getCurrentUserInfo().getUserID()));
				param.setDeptCode(mfrg002Form.getDeptCode());
				favDoctors = mfrg002Service.getFavDocsByDept(param);
			}

			List<RegDocInfoEntity> regDocList = new ArrayList<>();

			for (int i = 0; i < regInfoList.size(); i++) {
				RegisterInfoItem dbItem = regInfoList.get(i);
				RegDocInfoEntity entity = getDoctor(dbItem.getDoctorCode(), regDocList);
				if (entity == null) {
					entity = new RegDocInfoEntity();
				} else {
					regDocList.remove(entity);
				}

				if (isFavDoctor(favDoctors, dbItem.getDoctorCode())) {
					entity.setIsCurUserFav("1");
				} else {
					entity.setIsCurUserFav("0");
				}

				entity.setDoctorCode(dbItem.getDoctorCode());
				if (AM.equals(dbItem.getTimeFlag()) && !"0".equals(dbItem.getLeftNum())) {
					entity.setAmCanReg(CANREGISTER);
				} else if (AM.equals(dbItem.getTimeFlag())) {
					entity.setAmCanReg(CANNOTREGISTER);
				}
				if (PM.equals(dbItem.getTimeFlag()) && !"0".equals(dbItem.getLeftNum())) {
					entity.setPmCanReg(CANREGISTER);
				} else if (PM.equals(dbItem.getTimeFlag())) {
					entity.setPmCanReg(CANNOTREGISTER);
				}
				entity.setRegFee(String.valueOf(Integer.valueOf(dbItem.getRegFee()) / 100.00));

				DoctorBasicInfoEntity docEntity = getDoctorInfo(dbItem.getDoctorCode(), docEntityList);
				if (docEntity != null) {
					entity.setDoctorName(docEntity.getDoctorName());
					entity.setDoctorIntrodution(docEntity.getSummary());
					entity.setDoctorSkill(docEntity.getSkill());
					entity.setDoctorTitle(docEntity.getRank());
				}
				// TODO 暂无医生图片，用默认的
				entity.setDoctorPic("/images/doctor/default.jpg");
				regDocList.add(entity);
			}
			mfrg002Form.setRegDocList(regDocList);

		return forwardIndex();
	}

	/**
	 * 判断是否登录（session是否有效）。
	 * 
	 * @param mfrg002Form
	 *            画面From
	 * @return 判断结果 0：未登录 1：已登录
	 */
	@RequestMapping(value = "g/mfrg002/loginCheck", method = RequestMethod.POST)
	@ResponseBody
	public String loginCheck(@ModelAttribute Mfrg002Form mfrg002Form) {
		if (AhisCommonUtil.getCurrentUserInfo() == null) {
			return "0";
		}
		return "1";
	}

	/**
	 * 医生收藏。
	 * 
	 * @param mfrg002Form
	 *            画面From
	 * @return 收藏结果 0：收藏已存在 1：DB收藏失败 2：收藏成功
	 */
	@RequestMapping(value = "m/mfrg002/favDoctors", method = RequestMethod.POST)
	@ResponseBody
	public String favDoctors(@ModelAttribute Mfrg002Form mfrg002Form) {
		FavoriteDoctorsEntity paramEntity = new FavoriteDoctorsEntity();
		paramEntity.setUserId(new Long(AhisCommonUtil.getCurrentUserInfo().getUserID()));
		paramEntity.setDeptCode(mfrg002Form.getDeptCode());
		paramEntity.setDeptName(mfrg002Form.getDeptName());
		paramEntity.setDoctorCode(mfrg002Form.getDoctorCode());
		paramEntity.setDoctorName(mfrg002Form.getDoctorName());

		FavoriteDoctorsEntity entity = mfrg002Service.getFavDocByPrimaryKey(paramEntity);
		// 收藏已存在
		if (entity != null) {
			return "0";
		}
		int result = mfrg002Service.insertFavDoctor(paramEntity);
		if (result == 0) {
			// DB收藏失败
			return "1";
		}
		// 收藏成功
		return "2";
	}

	/**
	 * 删除医生收藏。
	 * 
	 * @param mfrg002Form
	 *            画面From
	 * @return 收藏结果 0：收藏不存在 1：DB删除失败 2：取消收藏成功
	 */
	@RequestMapping(value = "m/mfrg002/delfavDoctors", method = RequestMethod.POST)
	@ResponseBody
	public String delfavDoctors(@ModelAttribute Mfrg002Form mfrg002Form) {
		FavoriteDoctorsEntity paramEntity = new FavoriteDoctorsEntity();
		paramEntity.setUserId(new Long(AhisCommonUtil.getCurrentUserInfo().getUserID()));
		paramEntity.setDeptCode(mfrg002Form.getDeptCode());
		paramEntity.setDeptName(mfrg002Form.getDeptName());
		paramEntity.setDoctorCode(mfrg002Form.getDoctorCode());
		paramEntity.setDoctorName(mfrg002Form.getDoctorName());

		FavoriteDoctorsEntity entity = mfrg002Service.getFavDocByPrimaryKey(paramEntity);
		// 收藏不存在
		if (entity == null) {
			return "0";
		}
		// 收藏存在则删除
		int result = mfrg002Service.deleteByPrimaryKey(paramEntity);
		if (result == 0) {
			// DB删除失败
			return "1";
		}
		// 删除收藏成功
		return "2";
	}

	private List<DoctorBasicInfoEntity> getDocInfoList(String deptCode) {
		DoctorBasicInfoEntity entity = new DoctorBasicInfoEntity();
		entity.setHospitalCode("0001");
		entity.setDepartmentCode(deptCode);
		List<DoctorBasicInfoEntity> list = mfrg002Service.getDBDoctorListByHospital(entity);
		return list;
	}

	private RegDocInfoEntity getDoctor(String doctorCode, List<RegDocInfoEntity> regDocList) {
		for (int i = 0; i < regDocList.size(); i++) {
			if (regDocList.get(i).getDoctorCode().equals(doctorCode)) {
				return regDocList.get(i);
			}
		}
		return null;
	}

	private boolean isFavDoctor(List<FavoriteDoctorsEntity> doctors, String docotrCode) {
		for (int i = 0; i < doctors.size(); i++) {
			if (docotrCode.equals(doctors.get(i).getDoctorCode())) {
				return true;
			}
		}
		return false;
	}

	private DoctorBasicInfoEntity getDoctorInfo(String doctorCode, List<DoctorBasicInfoEntity> docEntityList) {
		for (int i = 0; i < docEntityList.size(); i++) {
			if (docEntityList.get(i).getDoctorCode().equals(doctorCode)) {
				return docEntityList.get(i);
			}
		}
		return null;
	}

	private boolean isDate1BeforeDate2(String date1, String date2) {
		int year1 = Integer.valueOf(date1.substring(0, date1.indexOf('年')));
		int year2 = Integer.valueOf(date2.substring(0, date2.indexOf('年')));

		int month1 = Integer.valueOf(date1.substring(date1.indexOf('年') + 1, date1.indexOf('月')));
		int month2 = Integer.valueOf(date2.substring(date2.indexOf('年') + 1, date2.indexOf('月')));

		int day1 = Integer.valueOf(date1.substring(date1.indexOf('月') + 1, date1.indexOf('日')));
		int day2 = Integer.valueOf(date2.substring(date2.indexOf('月') + 1, date2.indexOf('日')));

		if (year1 < year2 || (year1 == year2 && month1 < month2) || (year1 == year2 && month1 == month2 && day1 < day2)) {
			return true;
		}

		return false;
	}
}
