package com.xuanke.tset.dao;

import java.util.List;

import com.xuanke.tset.po.student;
import com.xuanke.tset.po.teacher;

public interface TeacherDAO {
	public int tadd(String tName,String technology);
	public int tda(int tId);
	public teacher tcx(int tId);
	public int tupdate(teacher t);
	public List<teacher> listteacher();
}
