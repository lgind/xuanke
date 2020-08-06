package com.xuanke.tset.view.impl;

import java.util.List;
import java.util.Scanner;

import com.xuanke.tset.dao.StudentDAO;
import com.xuanke.tset.dao.TeacherDAO;
import com.xuanke.tset.dao.impl.StudentDAOimpl;
import com.xuanke.tset.dao.impl.TeacherDAOimpl;
import com.xuanke.tset.po.student;
import com.xuanke.tset.po.teacher;
import com.xuanke.tset.view.TeacherView;

public class TeacherViewimpl implements TeacherView {
	TeacherDAO tea=new TeacherDAOimpl();
	Scanner sc=new Scanner(System.in);
	@Override
	public void tadd() {
		System.out.println("请输入教师名称:");
		String tName=sc.next();
		System.out.println("请输入教师的技术方向：");
		String technology=sc.next();
		int x= tea.tadd(tName, technology);
		if(x>0){
			System.out.println("添加成功");
		}else{
			System.out.println("添加失败");
		}
	}

	@Override
	public void tda() {
		System.out.println("请输入要删除的教师编号");
		int tId=sc.nextInt();
		System.out.println("是否确定删除(y/n)");
		String s=sc.next();
		if(s.equalsIgnoreCase("y")){
			int x =tea.tda(tId);
			if(x>0){
				System.out.println("删除成功");
			}else{
				System.out.println("删除失败");
			}
		}
	}

	@Override
	public void tupdate() {
		System.out.println("请输入要修改的教师ID：");
		int tid=sc.nextInt();
		teacher t= tea.tcx(tid);
		System.out.println("教师id:"+t.gettId()+" 教师名称："+t.gettName()+" 技术方向"+t.getTechonlogy());
		System.out.println("是否修改教师名称？(y/n)");
		String s=sc.next();
		if(s.equalsIgnoreCase("y")){
			System.out.println("请输入新的教师名称");
			t.settName(sc.next());
		}
		System.out.println("是否修改教师的技术方向？(y/n)");
		String c=sc.next();
		if(c.equalsIgnoreCase("y")){
			System.out.println("请输入新的技术方向");
			t.setTechonlogy(sc.next());
		}
		int x= tea.tupdate(t);
		if(x>0){
			System.out.println("修改完成");
		}else{
			System.out.println("未修改或修改失败");
		}
	}

	@Override
	public void tck() {
		List<teacher> listt= tea.listteacher();
		for(int i=0;i<listt.size();i++){
			teacher t=listt.get(i);
			System.out.println("教师id:"+t.gettId()+" 教师名称："+t.gettName()+" 技术方向"+t.getTechonlogy());
		}
	}

	@Override
	public void liststudent() {
		StudentDAO stu=new StudentDAOimpl();
		System.out.println("请输入查询的教师编号");
		int x=sc.nextInt();
		List<student> st= stu.liststudent1(x);
		for(int i=0;i<st.size();i++){
			student s=st.get(i);
			System.out.println("学生Id："+s.getsId()+" 学生姓名："+s.getsName()+" 学生专业："+s.getsClass());
		}
		
		
	}


}
