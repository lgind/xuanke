package com.xuanke.tset.view.impl;

import java.util.List;
import java.util.Scanner;

import com.xuanke.tset.dao.CourseDAO;
import com.xuanke.tset.dao.StudentDAO;
import com.xuanke.tset.dao.impl.CourseDAOimpl;
import com.xuanke.tset.dao.impl.StudentDAOimpl;
import com.xuanke.tset.po.course;
import com.xuanke.tset.po.student;
import com.xuanke.tset.view.CourseView;

public class CourseViewimpl implements CourseView {
	CourseDAO co=new CourseDAOimpl();
	Scanner sc=new Scanner(System.in);
	@Override
	public void cadd() {
		System.out.println("请输入课程名称:");
		String cName=sc.next();
		System.out.println("请输入课程课时：");
		int cHour=sc.nextInt();
		System.out.println("请输入课程讲师：");
		int tID=sc.nextInt();
		int x= co.cadd(cName, cHour,tID);
		if(x>0){
			System.out.println("添加成功");
		}else{
			System.out.println("添加失败");
		}
	}


	@Override
	public void cda() {
		System.out.println("请输入要删除的课程编号");
		int cId=sc.nextInt();
		System.out.println("是否确定删除(y/n)");
		String s=sc.next();
		if(s.equalsIgnoreCase("y")){
			int x =co.cda(cId);
			if(x>0){
				System.out.println("删除成功");
			}else{
				System.out.println("删除失败");
			}
		}
		
	}

	@Override
	public void cupdate() {
		System.out.println("请输入要修改的课程ID：");
		int tid=sc.nextInt();
		course t= co.tcx(tid);
		System.out.println("课程id:"+t.getcId()+" 课程名称："+t.getcName()+"  课程课时："+t.getcHour()+" 对应讲师："+t.gettId());
		System.out.println("是否修改课程名称？(y/n)");
		String s=sc.next();
		if(s.equalsIgnoreCase("y")){
			System.out.println("请输入新的课程名称");
			t.setcName(sc.next());
		}
		System.out.println("是否修改课程课时？(y/n)");
		String c=sc.next();
		if(c.equalsIgnoreCase("y")){
			System.out.println("请输入新的课程课时");
			t.setcHour(sc.nextInt());
		}
		int x= co.cupdate(t);
		if(x>0){
			System.out.println("修改完成");
		}else{
			System.out.println("未修改或修改失败");
		}
		
	}

	@Override
	public void cck() {
		List<course> listt= co.listcourse();
		for(int i=0;i<listt.size();i++){
			course t=listt.get(i);
			System.out.println("课程id:"+t.getcId()+" 课程名称："+t.getcName()+"  课程课时："+t.getcHour()+" 对应讲师："+t.gettId());
		}
		
	}


	@Override
	public void liststudent() {
		StudentDAO stu=new StudentDAOimpl();
		System.out.println("请输入查询的课程编号");
		int x=sc.nextInt();
		List<student> st= stu.liststudent(x);
		for(int i=0;i<st.size();i++){
			student s=st.get(i);
			System.out.println("学生Id："+s.getsId()+" 学生姓名："+s.getsName()+" 学生专业："+s.getsClass());
		}
		
		
	}

}
