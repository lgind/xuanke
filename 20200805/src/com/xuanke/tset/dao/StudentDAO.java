package com.xuanke.tset.dao;

import java.util.List;

import com.xuanke.tset.po.student;

public interface StudentDAO {
	public List<student> liststudent(int cId);
	public List<student> liststudent1(int tId);
	public student slogin(int sId);
	public int xkadd(int sId,int cId);
}
