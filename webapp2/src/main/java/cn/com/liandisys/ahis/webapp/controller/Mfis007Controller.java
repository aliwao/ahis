package cn.com.liandisys.ahis.webapp.controller;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisController;
import cn.com.liandisys.ahis.webapp.form.Mfis007Form;
import cn.com.liandisys.ahis.webapp.his.entity.request.base.HospitalizationBaseHisRequest;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.item.HospitalizationBaseItem;
import cn.com.liandisys.ahis.webapp.service.HospitalizationService;
import cn.com.liandisys.ahis.webapp.utils.AhisCommonUtil;


/**
 * 住院服务页面控制器。
 * 
 * @author xuyue
 * @version 1.0
 */
@Controller
@RequestMapping("m/mfis007/*")
public class Mfis007Controller extends AbstractAhisController<Mfis007Form> {

	/** 状态Flag 1:在院 */
	private static String HOSPITAL_STAY = "1";

	@Autowired
	private HospitalizationService hospitalizationService;

	@RequestMapping("index")
	public String index(@ModelAttribute Mfis007Form mfis007Form, HttpServletRequest req) {

		HospitalizationBaseHisRequest request = new HospitalizationBaseHisRequest();
		request.setPatCardType("1");
		request.setPatCardNo("1234567");

		List<HospitalizationBaseItem> itemList = hospitalizationService.getWx3yHospitalizationRecord(request);

		HospitalizationBaseItem stayRecord = null;
		for (int i = 0, len = itemList.size(); i < len; i++) {
			HospitalizationBaseItem item = itemList.get(i);
			if (HOSPITAL_STAY.equals(item.getStatus())) {
				stayRecord = itemList.get(i);
				break;
			}
		}

		mfis007Form.setUserName(AhisCommonUtil.getCurrentUserInfo().getFullName());
		mfis007Form.setHospitalName("无锡市第三人民医院");

		if (stayRecord != null) {
			mfis007Form.setDeptName(stayRecord.getDeptName());
			mfis007Form.setBed(stayRecord.getBedNo());
			mfis007Form.setStatusFlg(stayRecord.getStatus());
			mfis007Form.setTotalFee(stayRecord.getTotalFee());
			mfis007Form.setBalance(stayRecord.getBalance());

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
			mfis007Form.setTotalFee(String.valueOf(df.format(totalFee / 100.00)));
			mfis007Form.setBalance(String.valueOf(df.format(balance / 100.00)));
			mfis007Form.setTotalDeposit(String.valueOf(df.format(totalDeposit / 100.00)));

			Long stayCount = 0L;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			try {
				Date inDate = sdf.parse(stayRecord.getInDate());
				SimpleDateFormat inSdf = new SimpleDateFormat("yyyy年M月d日 EEEE");
				mfis007Form.setInDate(inSdf.format(inDate));

				Date outDate = new Date();
				if (stayRecord.getOutDate() != null && !stayRecord.getOutDate().isEmpty()) {
					outDate = sdf.parse(stayRecord.getOutDate());
				}
				stayCount = (outDate.getTime() - inDate.getTime()) / (1000 * 3600 * 24) + 1;
				mfis007Form.setStayCount(stayCount.toString());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else {
			mfis007Form.setStatusFlg("0");
		}

		return forwardIndex();
	}

}
