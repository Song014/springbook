package com.springbook.biz;

import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;

public class UserServiceClient {
	public static void main(String[] args) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");

		UserService us = (UserService) container.getBean("userServiceImpl");
		UserVO vo = new UserVO();
		
		String id = "";
		String pwd = "";
		Scanner sc = new Scanner(System.in);
		
		System.out.println("아이디 입력:");
		id = sc.next();
		System.out.println("비번 입력:");
		pwd = sc.next();
		
		vo.setId(id);
		vo.setPassword(pwd);
		
		UserVO user = us.getUser(vo);
		if( user != null) {
			System.out.println(user.getName() + "님 환영합니다.");
		} else {
			System.out.println("로그인 실패");
		}
		
		container.close();
	}
}
