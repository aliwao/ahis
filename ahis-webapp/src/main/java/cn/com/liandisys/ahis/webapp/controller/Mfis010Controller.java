package cn.com.liandisys.ahis.webapp.controller;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBException;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisController;
import cn.com.liandisys.ahis.webapp.entity.HospitalizationDayFeeEntity;
import cn.com.liandisys.ahis.webapp.form.Mfis010Form;
import cn.com.liandisys.ahis.webapp.his.entity.response.HospitalizationFeeResponse;
import cn.com.liandisys.ahis.webapp.his.entity.response.HospitalizationRecordItem;
import cn.com.liandisys.ahis.webapp.service.Mfis008Service;
import cn.com.liandisys.ahis.webapp.utils.AhisCommonUtil;


/**
 * 住院清单页面控制器。
 * 
 * @author xuyue
 * @version 1.0
 */
@Controller
@RequestMapping("m/mfis010/*")
public class Mfis010Controller extends AbstractAhisController<Mfis010Form> {

	@Autowired
	private Mfis008Service mfis0038ervice;

	@RequestMapping("index")
	public String index(@ModelAttribute Mfis010Form mfis010Form, HttpServletRequest req) {

		JSONObject json = new JSONObject();
		json.put("patCardType", "1");
		json.put("patCardNo", "1234567");
		List<HospitalizationRecordItem> itemList = new ArrayList<>();

			itemList = mfis0038ervice.getWx3yHospitalizationRecord(json);


		DecimalFormat df = new DecimalFormat("#0.00");
		double recievedDeposit = 0;
		double notPayed = 0;
		double totalFee = 0;

		List<HospitalizationDayFeeEntity> dayFeeList = new ArrayList<>();
		for (int i = 0, len = itemList.size(); i < len; i++) {
			HospitalizationRecordItem item = itemList.get(i);
			// 获取每次住院期间内 每日的费用情况
			getDayFeeOfPeriod(item, dayFeeList);

			totalFee = totalFee + Double.parseDouble(item.getTotalFee()) / 100.00;
		}

		mfis010Form.setUserName(AhisCommonUtil.getCurrentUserInfo().getFullName());
		mfis010Form.setDayFeeList(dayFeeList);

		mfis010Form.setRecievedDeposit(df.format(recievedDeposit));
		mfis010Form.setNotPayed(df.format(notPayed));
		mfis010Form.setTotalFee(df.format(totalFee));

		Collections.sort(dayFeeList, new HospitalizationDayFeeDateComparator());
		mfis010Form.setDayFeeList(dayFeeList);
		return forwardIndex();
	}

	private void getDayFeeOfPeriod(HospitalizationRecordItem item, List<HospitalizationDayFeeEntity> dayFeeList) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date inDay = sdf.parse(item.getInDate());
			Date outDay = sdf.parse(item.getOutDate());

			do {
				JSONObject json = new JSONObject();
				json.put("patCardType", "1");
				json.put("patCardNo", "1234567");
				json.put("admissionNum", item.getAdmissionNum());
				json.put("beginDate", sdf.format(inDay));
				json.put("endDate", sdf.format(inDay));

				HospitalizationFeeResponse reponse = mfis0038ervice.getWx3yHospitalizationFee(json);
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
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
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
