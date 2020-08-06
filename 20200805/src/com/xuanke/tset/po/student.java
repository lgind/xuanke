package com.xuanke.tset.po;

public class student {
	private String sName;
	private String sClass;
	private String keceng;
	private int sId;
	
	public student(String sName, String sClass, String keceng, int sId) {
		super();
		this.sName = sName;
		this.sClass = sClass;
		this.keceng = keceng;
		this.sId = sId;
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public String getKeceng() {
		return keceng;
	}

	public void setKeceng(String keceng) {
		this.keceng = keceng;
	}
	public student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsClass() {
		return sClass;
	}
	public void setsClass(String sClass) {
		this.sClass = sClass;
	}
	
	
}
