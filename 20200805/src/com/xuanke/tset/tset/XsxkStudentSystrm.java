package com.xuanke.tset.tset;

import java.util.Scanner;

import com.xuanke.tset.po.student;
import com.xuanke.tset.view.StudentView;
import com.xuanke.tset.view.impl.StudentViewimpl;

public class XsxkStudentSystrm {
	StudentView st=new StudentViewimpl();
	public void work(){
		System.out.println("-------------------------------------------------------------");
		System.out.println("-----------------------后台学生选课入口-----------------------");
		int x=0;
		Scanner sc=new Scanner(System.in);
		student s=null;
		s=st.slogin();
		if(s!=null){
			System.out.println("登录成功");
			while(x!=3){
			System.out.println("------------1.选课入口 2.查看已选课程 3.退出系统------------");
			x=sc.nextInt();
			switch (x) {
			case 1:
				st.sxk(s.getsId());
				break;
			case 2:
				st.syx(s.getsId());
				break;
			case 3:
				System.out.println("退出系统");
				break;
			default:
				System.out.println("输入非法");
				break;
			}
		}
		}else{
			System.out.println("登录失败");
		}
		
	}
	public static void main(String[] args) {
		XsxkStudentSystrm x=new XsxkStudentSystrm();
		x.work();
	}
}
