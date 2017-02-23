package cn.com.liandisys.ahis.webapp.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBException;

import net.sourceforge.pinyin4j.PinyinHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisController;
import cn.com.liandisys.ahis.webapp.dto.DepartmentBasicEntity;
import cn.com.liandisys.ahis.webapp.form.Mfrg001Form;
import cn.com.liandisys.ahis.webapp.service.Mfrg001Service;

/**
 * 选择科室页面控制器。
 * 
 * @author xuyue
 * @version 1.0
 */
@Controller
@RequestMapping("g/mfrg001/*")
public class Mfrg001Controller extends AbstractAhisController<Mfrg001Form> {

	@Autowired
	private Mfrg001Service mfrg001Service;

	/** DB科室信息 */
	private List<DepartmentBasicEntity> deptItemlist;

	/**
	 * 选择科室页面显示。
	 * 
	 * @param mfrg001Form
	 *            画面From
	 * @return 画面显示
	 */
	@RequestMapping("index")
	public String index(@ModelAttribute Mfrg001Form mfrg001Form, HttpServletRequest req) {
		deptItemlist = mfrg001Service.getDBDeptListByHospital("0001");
		Map<String, List<DepartmentBasicEntity>> deptMap = findDeptMap(mfrg001Form);
		mfrg001Form.setDeptItemMap(deptMap);
		return forwardIndex();
	}

	/**
	 * 科室检索mock。
	 * 
	 * @param mfrg001Form
	 *            画面From
	 * @return 画面url
	 * @throws JAXBException
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "deptSearch", method = RequestMethod.POST)
	public String deptSearch(@ModelAttribute Mfrg001Form mfrg001Form) throws UnsupportedEncodingException, JAXBException {

		Map<String, List<DepartmentBasicEntity>> deptMap = findDeptMap(mfrg001Form);
		mfrg001Form.setDeptItemMap(deptMap);
		return forwardIndex();
	}

	/**
	 * 科室检索autocomplete。
	 * 
	 * @param mfrg001Form
	 *            画面From
	 * @return 科室json
	 */
	@RequestMapping("deptList")
	@ResponseBody
	public String deptList(@ModelAttribute Mfrg001Form mfrg001Form) {
		if (deptItemlist == null || deptItemlist.isEmpty()) {
			return "";
		}

		StringBuffer dept = new StringBuffer();
		deptItemlist.forEach(item -> {
			if (item.getDepartmentName().contains(mfrg001Form.getDeptName())) {
				if (dept.length() == 0) {
					dept.append("[");
				}
				dept.append("{\"label\":\"" + item.getDepartmentName() + "\",\"value\":\"" + item.getDepartmentName() + "\",\"id\":\""
						+ item.getDepartmentCode() + "\"},");
			}
		});
		String deptStr = dept.toString();
		if (dept.length() != 0) {
			deptStr = dept.substring(0, dept.length() - 1);
			deptStr = deptStr + "]";
		}
		return deptStr;
	}

	private Map<String, List<DepartmentBasicEntity>> findDeptMap(Mfrg001Form mfrg001Form) {
		Map<String, List<DepartmentBasicEntity>> deptMap = new TreeMap<String, List<DepartmentBasicEntity>>();

		String searchWord = mfrg001Form.getDeptName();
		deptItemlist.forEach(item -> {
			if ((searchWord != null && !searchWord.trim().isEmpty() && !item.getDepartmentName().contains(searchWord.trim()))
					|| !"0".equals(item.getHasChild())) {
				return;
			}

			String[] rs = PinyinHelper.toHanyuPinyinStringArray(item.getDepartmentName().charAt(0));
			String firstAlphabet;
			if (rs == null) {
				firstAlphabet = "#" + item.getDepartmentName().substring(0, 1).toUpperCase();
			} else {
				firstAlphabet = "#" + rs[0].substring(0, 1).toUpperCase();
			}

			item.setCanRegister("1"); // 是否可挂号判断待

				List<DepartmentBasicEntity> existList = deptMap.get(firstAlphabet);
				if (existList == null) {
					List<DepartmentBasicEntity> list = new ArrayList<>();
					list.add(item);
					deptMap.put(firstAlphabet, list);
				} else {
					existList.add(item);
					deptMap.put(firstAlphabet, existList);
				}
			});
		return deptMap;
	}

}
