package cn.com.liandisys.ahis.webapp.controller;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisController;
import cn.com.liandisys.ahis.webapp.entity.HospitalizationDayFeeEntity;
import cn.com.liandisys.ahis.webapp.form.Mfis009Form;
import cn.com.liandisys.ahis.webapp.his.entity.request.base.HospitalizationBaseHisRequest;
import cn.com.liandisys.ahis.webapp.his.entity.request.base.HospitalizationFeeBaseHisRequest;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.HospitalizationFeeBaseHisResponse;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.item.HospitalizationBaseItem;
import cn.com.liandisys.ahis.webapp.service.HospitalizationService;
import cn.com.liandisys.ahis.webapp.utils.AhisCommonUtil;

/**
 * 住院清单页面控制器。
 * 
 * @author xuyue
 * @version 1.0
 */
@Controller
@RequestMapping("m/mfis009/*")
public class Mfis009Controller extends AbstractAhisController<Mfis009Form> {

	@Autowired
	private HospitalizationService hospitalizationService;

	@RequestMapping("index")
	public String index(@ModelAttribute Mfis009Form mfis009Form, HttpServletRequest req) {

		HospitalizationBaseHisRequest request = new HospitalizationBaseHisRequest();
		request.setPatCardType("1");
		request.setPatCardNo("1234567");
		List<HospitalizationBaseItem> itemList = hospitalizationService.getWx3yHospitalizationRecord(request);

		DecimalFormat df = new DecimalFormat("#0.00");
		double recievedDeposit = 0;
		double notPayed = 0;
		double totalFee = 0;

		List<HospitalizationDayFeeEntity> dayFeeList = new ArrayList<>();
		for (int i = 0, len = itemList.size(); i < len; i++) {
			HospitalizationBaseItem item = itemList.get(i);
			// 获取每次住院期间内 每日的费用情况
			getDayFeeOfPeriod(item, dayFeeList);

			totalFee = totalFee + Double.parseDouble(item.getTotalFee()) / 100.00;
		}

		mfis009Form.setUserName(AhisCommonUtil.getCurrentUserInfo().getFullName());
		mfis009Form.setDayFeeList(dayFeeList);

		mfis009Form.setRecievedDeposit(df.format(recievedDeposit));
		mfis009Form.setNotPayed(df.format(notPayed));
		mfis009Form.setTotalFee(df.format(totalFee));

		Collections.sort(dayFeeList, new HospitalizationDayFeeDateComparator());
		mfis009Form.setDayFeeList(dayFeeList);
		return forwardIndex();
	}

	private void getDayFeeOfPeriod(HospitalizationBaseItem item, List<HospitalizationDayFeeEntity> dayFeeList) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Date inDay = sdf.parse(item.getInDate());
			Date outDay = sdf.parse(item.getOutDate());

			do {
				HospitalizationFeeBaseHisRequest request = new HospitalizationFeeBaseHisRequest();
				request.setPatCardType("1");
				request.setPatCardNo("1234567");
				request.setAdmissionNum(item.getAdmissionNum());
				request.setBeginDate(sdf.format(inDay));
				request.setEndDate(sdf.format(inDay));

				HospitalizationFeeBaseHisResponse reponse = hospitalizationService.getWx3yHospitalizationFee(request);
				if (reponse.getResultCode() == null) {
					return;
				}

				HospitalizationDayFeeEntity entity = new HospitalizationDayFeeEntity();
				SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy年M月d日 EEEE");
				DecimalFormat df = new DecimalFormat("#0.00");
				entity.setDate(sdf.format(inDay));
				entity.setDateStr(sdfDate.format(inDay));

				if (reponse.getTotalFee() != null && !reponse.getTotalFee().isEmpty()) {
					entity.setTotalFee(df.format(Double.parseDouble(reponse.getTotalFee()) / 100.00));
				}
				if (reponse.getFeeA() != null && !reponse.getFeeA().isEmpty()) {
					entity.setFeeA(df.format(Double.parseDouble(reponse.getFeeA()) / 100.00));
				}
				if (reponse.getFeeB() != null && !reponse.getFeeB().isEmpty()) {
					entity.setFeeB(df.format(Double.parseDouble(reponse.getFeeB()) / 100.00));
				}
				if (reponse.getFeeC() != null && !reponse.getFeeC().isEmpty()) {
					entity.setFeeC(df.format(Double.parseDouble(reponse.getFeeC()) / 100.00));
				}
				if (reponse.getBedFee() != null && !reponse.getBedFee().isEmpty()) {
					entity.setBedFee(df.format(Double.parseDouble(reponse.getBedFee()) / 100.00));
				}
				if (reponse.getWestMedFee() != null && !reponse.getWestMedFee().isEmpty()) {
					entity.setWestMedFee(df.format(Double.parseDouble(reponse.getWestMedFee()) / 100.00));
				}
				if (reponse.getReadyMedFee() != null && !reponse.getReadyMedFee().isEmpty()) {
					entity.setReadyMedFee(df.format(Double.parseDouble(reponse.getReadyMedFee()) / 100.00));
				}
				if (reponse.getHerbMedFee() != null && !reponse.getHerbMedFee().isEmpty()) {
					entity.setHerbMedFee(df.format(Double.parseDouble(reponse.getHerbMedFee()) / 100.00));
				}
				if (reponse.getTreatFee() != null && !reponse.getTreatFee().isEmpty()) {
					entity.setTreatFee(df.format(Double.parseDouble(reponse.getTreatFee()) / 100.00));
				}
				dayFeeList.add(entity);

				inDay = DateUtils.addDays(inDay, 1);
			} while (inDay.before(outDay) || inDay.equals(outDay));

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 费用清单排序（按日期降序排）。
	 */
	public static class HospitalizationDayFeeDateComparator implements Comparator<HospitalizationDayFeeEntity> {

		@Override
		public int compare(HospitalizationDayFeeEntity en1, HospitalizationDayFeeEntity en2) {
			return -en1.getDate().compareTo(en2.getDate());

		}
	}

}
