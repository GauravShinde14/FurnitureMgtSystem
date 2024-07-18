package com.gaurav.ImageUpload.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BuyNow {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bid;
	
	private String bname,bprice,btype,bemail;

	public BuyNow() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BuyNow(String bname, String bprice, String btype, String bemail) {
		super();
		this.bname = bname;
		this.bprice = bprice;
		this.btype = btype;
		this.bemail = bemail;
	}

	public Long getBid() {
		return bid;
	}

	public void setBid(Long bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBprice() {
		return bprice;
	}

	public void setBprice(String bprice) {
		this.bprice = bprice;
	}

	public String getBtype() {
		return btype;
	}

	public void setBtype(String btype) {
		this.btype = btype;
	}

	public String getBemail() {
		return bemail;
	}

	public void setBemail(String bemail) {
		this.bemail = bemail;
	}
	
	
	
}
