package com.xuanke.tset.po;

public class course {
	private String cName;
	private int cHour;
	private int tId;
	private int cId;
	
	public course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public course(String cName, int cHour, int tId, int cId) {
		super();
		this.cName = cName;
		this.cHour = cHour;
		this.tId = tId;
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public int getcHour() {
		return cHour;
	}
	public void setcHour(int cHour) {
		this.cHour = cHour;
	}
	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	
	
}
