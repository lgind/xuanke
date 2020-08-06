package com.xuanke.tset.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xuanke.tset.dao.TeacherDAO;
import com.xuanke.tset.po.student;
import com.xuanke.tset.po.teacher;
import com.xuanke.tset.util.BaseDAO;

public class TeacherDAOimpl extends BaseDAO implements TeacherDAO {
		List<teacher> listt =new ArrayList<teacher>();
	@Override
	public int tadd(String tName, String technology) {
		String sql="INSERT INTO teacher(tName,technology) VALUES(?,?)";
		PreparedStatement pr=null;
		int re=0;
		try {
			pr=getconn().prepareStatement(sql);
			pr.setString(1, tName);
			pr.setString(2, technology);
			re=pr.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			close(null, pr, null);
		}
		
		return re;
	}

	@Override
	public int tda(int tId) {
		String sql1="DELETE FROM teacher WHERE tId=?";
		String sql="DELETE FROM course WHERE tId=?";
		String sql2="DELETE FROM stucou WHERE cId IN(SELECT cId FROM course WHERE tId=?)";
		PreparedStatement pr=null;
		int re=0;
		try {
			getconn().setAutoCommit(false);
			pr=getconn().prepareStatement(sql2);
			pr.setInt(1, tId);
			pr=getconn().prepareStatement(sql);
			pr.setInt(1, tId);
			pr=getconn().prepareStatement(sql1);
			pr.setInt(1, tId);
			getconn().commit();
			re=pr.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
			try {
				getconn().rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally{
			close(null, pr, null);
		}
		
		return re;
	}

	@Override
	public teacher tcx(int tId) {
		String sql="SELECT tId,tName,technology FROM teacher WHERE tId=?";
		PreparedStatement pr=null;
		teacher te=null;
		ResultSet re=null;
		try {
			pr=getconn().prepareStatement(sql);
			pr.setInt(1, tId);
			re=pr.executeQuery();
			if(re.next()){
				te=new teacher();
				te.settName(re.getString("tName"));
				te.setTechonlogy(re.getString("technology"));
				te.settId(re.getInt("tId"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			close(null, pr, re);
		}
		return te;
	}

	@Override
	public int tupdate(teacher t) {
		String sql="UPDATE teacher SET tName=?,technology=? WHERE tId=?";
		PreparedStatement pr=null;
		int x=0;
		try {
			pr=getconn().prepareStatement(sql);
			pr.setString(1,t.gettName());
			pr.setString(2, t.getTechonlogy());
			pr.setInt(3,t.gettId());
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
	public List<teacher> listteacher() {
		String sql="SELECT tId,tName,technology FROM teacher";
		PreparedStatement pr=null;
		teacher te=null;
		ResultSet re=null;

		try {
			pr=getconn().prepareStatement(sql);
			re=pr.executeQuery();
			while(re.next()){
				te=new teacher();
				te.settName(re.getString("tName"));
				te.setTechonlogy(re.getString("technology"));
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

}
