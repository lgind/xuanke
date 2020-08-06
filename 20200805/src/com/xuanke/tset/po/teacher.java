package com.xuanke.tset.po;

public class teacher {
	private String tName;
	private String techonlogy;
	private int tId;
	
	
	public teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public teacher(String tName, String techonlogy, int tId) {
		super();
		this.tName = tName;
		this.techonlogy = techonlogy;
		this.tId = tId;
	}
	
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public String getTechonlogy() {
		return techonlogy;
	}
	public void setTechonlogy(String techonlogy) {
		this.techonlogy = techonlogy;
	}
	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
	}
	
	
}
