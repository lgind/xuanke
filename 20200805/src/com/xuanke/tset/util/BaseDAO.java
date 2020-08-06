package com.xuanke.tset.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDAO {
	
	private static Connection conn;
	public static final String DRIVER ="org.gjt.mm.mysql.Driver";
	public static final String URL ="jdbc:mysql://127.0.0.1:3306/xsxk";
	public static final String USERNAME ="root";
	public static final String PASSWORD ="aaaccc";
	static{
		try {
			Class.forName(DRIVER);
			conn=DriverManager.getConnection(URL,USERNAME,PASSWORD );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Connection getconn(){
		return conn;
	}
	
	public static void close(Connection conn,Statement stmt,ResultSet re){
		if(re != null){
			try {
				re.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(stmt !=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn !=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
