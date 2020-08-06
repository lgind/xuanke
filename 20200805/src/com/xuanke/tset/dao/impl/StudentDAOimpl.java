package com.xuanke.tset.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xuanke.tset.dao.StudentDAO;
import com.xuanke.tset.po.student;
import com.xuanke.tset.util.BaseDAO;

public class StudentDAOimpl extends BaseDAO implements StudentDAO {
	

	@Override
	public List<student> liststudent(int cId) {
		String sql="SELECT DISTINCT(s.sId),s.sName,s.sClass FROM student s,stucou t WHERE s.`sId`=t.`sId` AND t.cId =?";
		PreparedStatement pr=null;
		List<student> st=new ArrayList<student>();
		student te=null;
		ResultSet re=null;
		try {
			pr=getconn().prepareStatement(sql);
			pr.setInt(1, cId);
			re=pr.executeQuery();
			while(re.next()){
				te=new student();
				te.setsId(re.getInt("s.sId"));
				te.setsName(re.getString("s.sName"));
				te.setsClass(re.getString("s.sClass"));
				st.add(te);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			close(null, pr, re);
		}
		return st;
	}


	@Override
	public List<student> liststudent1(int tId) {
		String sql="SELECT DISTINCT(s.sId),s.sName,s.sClass FROM student s,stucou t WHERE s.`sId`=t.`sId` AND t.cId IN(SELECT cId FROM teacher WHERE tId =?);";
		PreparedStatement pr=null;
		List<student> st=new ArrayList<student>();
		student te=null;
		ResultSet re=null;
		try {
			pr=getconn().prepareStatement(sql);
			pr.setInt(1, tId);
			re=pr.executeQuery();
			while(re.next()){
				te=new student();
				te.setsId(re.getInt("s.sId"));
				te.setsName(re.getString("s.sName"));
				te.setsClass(re.getString("s.sClass"));
				st.add(te);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			close(null, pr, re);
		}
		return st;
	}


	@Override
	public student slogin(int sId) {
		String sql="SELECT sName,sId,sClass FROM student WHERE sId=?";
		PreparedStatement pr=null;
		ResultSet re=null;
		student st=null;
		try {
			pr=getconn().prepareStatement(sql);
			pr.setInt(1, sId);
			re=pr.executeQuery();
			if(re.next()){
				st=new student();
				st.setsId(re.getInt("sId"));
				st.setsName(re.getString("sName"));
				st.setsClass(re.getString("sClass"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			close(null,pr,re);
		}
		
		return st;
	}


	@Override
	public int xkadd(int sId, int cId) {
		String sql="INSERT INTO stucou(sId,cId) VALUES(?,?)";
		PreparedStatement pr=null;
		int re=0;
		try {
			pr=getconn().prepareStatement(sql);
			pr.setInt(1,sId);
			pr.setInt(2, cId);
			re=pr.executeUpdate();
		} catch (SQLException e) {
			System.out.println("未找到指定课程");
		}finally{
			close(null, pr, null);
		}
		
		return re;
	}

}
