package com.xuanke.tset.view.impl;

import java.util.List;
import java.util.Scanner;

import com.xuanke.tset.dao.CourseDAO;
import com.xuanke.tset.dao.StudentDAO;
import com.xuanke.tset.dao.impl.CourseDAOimpl;
import com.xuanke.tset.dao.impl.StudentDAOimpl;
import com.xuanke.tset.po.course;
import com.xuanke.tset.po.student;
import com.xuanke.tset.view.StudentView;

public class StudentViewimpl implements StudentView {
	StudentDAO stud=new StudentDAOimpl();
	Scanner sc=new Scanner(System.in);
	
	@Override
	public student slogin() {
		System.out.println("请输入学号");
		int sId=sc.nextInt();
		return stud.slogin(sId);
	}

	@Override
	public void sxk(int sId) {
		String a="%";
		String b="%";
		System.out.println("是否按照教师进行选课？(y/n)");
		if(sc.next().equalsIgnoreCase("y")){
			System.out.println("请输入教师姓名");
			a=sc.next();
		}
		System.out.println("是否按照课程名称进行选课？(y/n)");
		if(sc.next().equalsIgnoreCase("y")){
			System.out.println("请输入课程名称");
			b=sc.next();
		}
		List<course> listt =null;
		CourseDAO co=new CourseDAOimpl();
		course c=null;
		listt= co.sxk(a,b);
		for(int i=0;i<listt.size();i++){
			c=listt.get(i);
			System.out.println("课程编号："+c.getcId()+" 课程名称："+c.getcName()+" 课程课时："+c.getcHour()+" 对应讲师："+c.gettId());
		}
		
		System.out.println("请输入选课的编号");
		int d=sc.nextInt();
		CourseDAO coo=new CourseDAOimpl();
		if(coo.ssk(sId, d)!=null){
			System.out.println("禁止重复选课");
		}else{
			int f= stud.xkadd(sId, d);
			if(f>0){
				System.out.println("选课成功");
			}else{
				System.out.println("选课失败");
		}


		
			
		}
	}

	@Override
	public void syx(int sId) {
		List<course> listt =null;
		CourseDAO co=new CourseDAOimpl();
		course c=null;
		
		listt= co.syx(sId);
		for(int i=0;i<listt.size();i++){
			c=listt.get(i);
			System.out.println("课程编号："+c.getcId()+" 课程名称："+c.getcName()+" 课程课时："+c.getcHour()+" 对应讲师："+c.gettId());
		}
		
	}

}
