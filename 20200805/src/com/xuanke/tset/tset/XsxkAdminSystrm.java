package com.xuanke.tset.tset;

import java.util.Scanner;

import com.xuanke.tset.view.CourseView;
import com.xuanke.tset.view.TeacherView;
import com.xuanke.tset.view.impl.CourseViewimpl;
import com.xuanke.tset.view.impl.TeacherViewimpl;

public class XsxkAdminSystrm {
	public void work(){
		System.out.println("-------------------------------------------------------------");
		System.out.println("------------------------后台管理员入口------------------------");
		int x=0;
		Scanner sc=new Scanner(System.in);
		while(x!=3){
			System.out.println("------------1.课程管理模块 2.教师管理模块 3.退出系统------------");
			x=sc.nextInt();
			switch (x) {
			case 1:
				work1();
				break;
			case 2:
				work2();
				break;
			case 3:
				System.out.println("退出系统");
				break;
			default:
				System.out.println("输入非法");
				break;
			}
		}
	}
	
	public void work1(){
		int x=0;
		Scanner sc=new Scanner(System.in);
		CourseView co=new CourseViewimpl();
		while(x!=6){
			System.out.println("------------1.添加课程 2.删除课程 3.修改课程 4.查询所有课程 5.查询某一课程下所有学生信息 6.返回上一级菜单------------");
			x=sc.nextInt();

			switch (x) {
			case 1:
				co.cadd();
				break;
			case 2:
				co.cda();
				break;
			case 3:
				co.cupdate();
				break;
			case 4:
				co.cck();
				break;
			case 5:
				co.liststudent();
				break;
			case 6:
				System.out.println("返回上一级菜单");
				break;
			default:
				System.out.println("输入非法");
				break;
			}
		}
	}
	
	public void work2(){
		int x=0;
		Scanner sc=new Scanner(System.in);
		TeacherView co=new TeacherViewimpl();
		while(x!=6){			
			System.out.println("------------1.添加教师 2.删除教师 3.修改教师 4.查询所有教师 5.查询某一教师下所有学生信息 6.返回上一级菜单------------");
			x=sc.nextInt();

			switch (x) {
			case 1:
				co.tadd();
				break;
			case 2:
				co.tda();
				break;
			case 3:
				co.tupdate();
				break;
			case 4:
				co.tck();
				break;
			case 5:
				co.liststudent();
				break;
			case 6:
				System.out.println("返回上一级菜单");
				break;
			default:
				System.out.println("输入非法");
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		XsxkAdminSystrm x=new XsxkAdminSystrm();
		x.work();
	}
}
