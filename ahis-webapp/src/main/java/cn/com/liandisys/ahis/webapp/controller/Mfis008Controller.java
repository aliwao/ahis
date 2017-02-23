package cn.com.liandisys.ahis.webapp.controller;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisController;
import cn.com.liandisys.ahis.webapp.form.Mfih008Form;
import cn.com.liandisys.ahis.webapp.his.entity.response.HospitalizationRecordItem;
import cn.com.liandisys.ahis.webapp.service.Mfis008Service;
import cn.com.liandisys.ahis.webapp.utils.AhisCommonUtil;


/**
 * 住院详细页面控制器。
 * 
 * @author xuyue
 * @version 1.0
 */
@Controller
@RequestMapping("m/mfis008/*")
public class Mfis008Controller extends AbstractAhisController<Mfih008Form> {

	/** 状态Flag 1:在院 */
	private static String HOSPITAL_STAY = "1";

	@Autowired
	private Mfis008Service mfis008ervice;

	@RequestMapping("index")
	public String index(@ModelAttribute Mfih008Form mfih008Form, HttpServletRequest req) {

		JSONObject json = new JSONObject();
		json.put("patCardType", "1");
		json.put("patCardNo", "1234567");
		List<HospitalizationRecordItem> itemList = new ArrayList<>();

			itemList = mfis008ervice.getWx3yHospitalizationRecord(json);

		HospitalizationRecordItem stayRecord = null;
		for (int i = 0, len = itemList.size(); i < len; i++) {
			HospitalizationRecordItem item = itemList.get(i);
			if (HOSPITAL_STAY.equals(item.getStatus())) {
				stayRecord = itemList.get(i);
				break;
			}
		}

		mfih008Form.setUserName(AhisCommonUtil.getCurrentUserInfo().getFullName());
		mfih008Form.setHospitalName("无锡市第三人民医院");

		if (stayRecord != null) {
			mfih008Form.setDeptName(stayRecord.getDeptName());
			mfih008Form.setBed(stayRecord.getBedNo());
			mfih008Form.setStatusFlg(stayRecord.getStatus());
			mfih008Form.setTotalFee(stayRecord.getTotalFee());
			mfih008Form.setBalance(stayRecord.getBalance());

			double totalFee = 0;
			if (stayRecord.getTotalFee() != null && !stayRecord.getTotalFee().isEmpty()) {
				totalFee = Double.valueOf(stayRecord.getTotalFee());
			}
			double balance = 0;
			if (stayRecord.getBalance() != null && !stayRecord.getBalance().isEmpty()) {
				balance = Double.valueOf(stayRecord.getBalance());
			}
			double totalDeposit = totalFee + balance;
			DecimalFormat df = new DecimalFormat("#.00");
			mfih008Form.setTotalFee(String.valueOf(df.format(totalFee / 100.00)));
			mfih008Form.setBalance(String.valueOf(df.format(balance / 100.00)));
			mfih008Form.setTotalDeposit(String.valueOf(df.format(totalDeposit / 100.00)));

			Long stayCount = 0L;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			try {
				Date inDate = sdf.parse(stayRecord.getInDate());
				SimpleDateFormat inSdf = new SimpleDateFormat("yyyy年M月d日 EEEE");
				mfih008Form.setInDate(inSdf.format(inDate));

				Date outDate = new Date();
				if (stayRecord.getOutDate() != null && !stayRecord.getOutDate().isEmpty()) {
					outDate = sdf.parse(stayRecord.getOutDate());
				}
				stayCount = (outDate.getTime() - inDate.getTime()) / (1000 * 3600 * 24) + 1;
				mfih008Form.setStayCount(stayCount.toString());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else {
			mfih008Form.setStatusFlg("0");
		}

		return forwardIndex();
	}

}
