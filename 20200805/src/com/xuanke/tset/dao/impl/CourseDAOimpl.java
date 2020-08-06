package com.xuanke.tset.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xuanke.tset.dao.CourseDAO;
import com.xuanke.tset.po.course;
import com.xuanke.tset.po.student;
import com.xuanke.tset.po.teacher;
import com.xuanke.tset.util.BaseDAO;

public class CourseDAOimpl extends BaseDAO implements CourseDAO {
	List<course> listt =new ArrayList<course>();
	@Override
	public int cadd(String cName, int cHour, int tId) {
		String sql="INSERT INTO course(cName,cHour,tId) VALUES(?,?,?)";
		PreparedStatement pr=null;
		int re=0;
		try {
			pr=getconn().prepareStatement(sql);
			pr.setString(1, cName);
			pr.setInt(2,cHour);
			pr.setInt(3, tId);
			re=pr.executeUpdate();
		} catch (SQLException e) {
			System.out.println("没有找到指定老师");
		}finally{
			close(null, pr, null);
		}
		
		return re;
	}

	@Override
	public int cda(int cId) {
		String sql="DELETE FROM course WHERE cId=?";
		String sql2="DELETE FROM stucou WHERE cId=?";
		PreparedStatement pr=null;
		int re=0;
		try {
			getconn().setAutoCommit(false);
			pr=getconn().prepareStatement(sql2);
			pr.setInt(1, cId);
			
			pr=getconn().prepareStatement(sql);
			pr.setInt(1, cId);
			getconn().commit();
			re=pr.executeUpdate();
		} catch (SQLException e) {
			try {
				getconn().rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			close(null, pr, null);
		}
		
		return re;
	}

	@Override
	public course tcx(int cId) {
		String sql="SELECT cId,cName,cHour,tId FROM course WHERE cId=?";
		PreparedStatement pr=null;
		course te=null;
		ResultSet re=null;
		try {
			pr=getconn().prepareStatement(sql);
			pr.setInt(1, cId);
			re=pr.executeQuery();
			if(re.next()){
				te=new course();
				te.setcName(re.getString("cName"));
				te.setcHour(re.getInt("cHour"));
				te.settId(re.getInt("tId"));
				te.setcId(re.getInt("cId"));
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			close(null, pr, re);
		}
		return te;
	}

	@Override
	public int cupdate(course c) {
		String sql="UPDATE course SET cName=?,cHour=? WHERE cId=?";
		PreparedStatement pr=null;
		int x=0;
		try {
			pr=getconn().prepareStatement(sql);
			pr.setString(1,c.getcName());
			pr.setInt(2, c.getcHour());
			pr.setInt(3,c.getcId());
			x=pr.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(null, pr,null);
		}
		return x;
	}

	@Override
	public List<course> listcourse() {
		String sql="SELECT cId,cName,cHour,tId FROM course";
		PreparedStatement pr=null;
		course te=null;
		ResultSet re=null;

		try {
			pr=getconn().prepareStatement(sql);
			re=pr.executeQuery();
			while(re.next()){
				te=new course();
				te.setcName(re.getString("cName"));
				te.setcId(re.getInt("cId"));
				te.setcHour(re.getInt("cHour"));
				te.settId(re.getInt("tId"));
				listt.add(te);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			close(null, pr, re);
		}
		return listt;
	}

	@Override
	public List<course> syx(int sId) {
		String sql="SELECT c.cId,c.cName,c.cHour,c.cId FROM course c,stucou t WHERE c.`cId`=t.`cId` AND t.sId =?";
		PreparedStatement pr=null;
		course te=null;
		ResultSet re=null;
		try {
			pr=getconn().prepareStatement(sql);
			pr.setInt(1, sId);
			re=pr.executeQuery();
			while(re.next()){
				te=new course();
				te.setcId(re.getInt("c.cId"));
				te.setcName(re.getString("c.cName"));
				te.setcHour(re.getInt("c.cHour"));
				te.settId(re.getInt("c.cId"));
				listt.add(te);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(null, pr, re);
		}
		
		
		return listt;
	}

	@Override
	public List<course> sxk(String a,String b) {
		String sql="SELECT c.cId,c.cName,c.cHour,c.cId FROM course c,teacher t WHERE c.`tId`=t.`tId` AND t.`tName` LIKE '%"+a+"%' AND c.`cName` LIKE '%"+b+"%';";
		PreparedStatement pr=null;
		course te=null;
		ResultSet re=null;
		try {
			pr=getconn().prepareStatement(sql);
			re=pr.executeQuery();
			while(re.next()){
				te=new course();
				te.setcId(re.getInt("c.cId"));
				te.setcName(re.getString("c.cName"));
				te.setcHour(re.getInt("c.cHour"));
				te.settId(re.getInt("c.cId"));
				listt.add(te);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(null, pr, re);
		}
		
		
		return listt;
	}

	@Override
	public course ssk(int sId, int cId) {
		String sql="SELECT c.cId FROM course c,stucou t WHERE c.`cId`=t.`cId` AND t.sId =? AND c.`cId`=?";
		PreparedStatement pr=null;
		course te=null;
		ResultSet re=null;
		try {
			pr=getconn().prepareStatement(sql);
			pr.setInt(1, sId);
			pr.setInt(2, cId);
			re=pr.executeQuery();
			if(re.next()){
				te=new course();
				te.setcId(re.getInt("c.cId"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return te;
	}
	
	
}
