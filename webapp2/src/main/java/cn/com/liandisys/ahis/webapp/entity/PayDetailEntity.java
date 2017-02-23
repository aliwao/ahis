package cn.com.liandisys.ahis.webapp.entity;

import java.io.Serializable;

public class PayDetailEntity implements Serializable {

	private static final long serialVersionUID = 4975329640243881062L;

	private String name;
	private String type;
	private String spec;
	private double price;
	private int number;
	private double totalAmt;
	private double medInsAmt;
	private double selfAmt;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(double totalAmt) {
		this.totalAmt = totalAmt;
	}

	public double getMedInsAmt() {
		return medInsAmt;
	}

	public void setMedInsAmt(double medInsAmt) {
		this.medInsAmt = medInsAmt;
	}

	public double getSelfAmt() {
		return selfAmt;
	}

	public void setSelfAmt(double selfAmt) {
		this.selfAmt = selfAmt;
	}

}
