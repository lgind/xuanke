package com.xuanke.tset.dao;

import java.util.List;

import com.xuanke.tset.po.course;
import com.xuanke.tset.po.student;

public interface CourseDAO {
	public int cadd(String cName,int cHour,int tId);
	public int cda(int cId);
	public course tcx(int cId);
	public int cupdate(course c);
	public List<course> listcourse();
	public List<course> sxk(String a,String b);
	public List<course> syx(int sId);
	public course ssk(int sId,int cId);
}
