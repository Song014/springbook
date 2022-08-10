package com.springbook.biz;

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");

	@Autowired
	BoardService bs;

	UserService us = (UserService) container.getBean("userServiceImpl");

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {

		List<BoardVO> boardList = bs.getBoardList();
		model.addAttribute("boardList", boardList);
		for (BoardVO list : boardList) {
			System.out.println(list);
		}

		return "home";
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user(Model model) {
//		UserVO vo = new UserVO();
//		vo.setId("test");
//		vo.setPassword("test1234");
//		UserVO userList = us.getUser(vo);
//		System.out.println(userList + "====Controller");
//
//		List<UserVO> User = us.getUserList();
//		model.addAttribute("boardList",User);
		UserVO vo = new UserVO();

//		String id = "";
//		String pwd = "";
//		Scanner sc = new Scanner(System.in);

//		System.out.println("아이디 입력:");
//		id = sc.next();
//		System.out.println("비번 입력:");
//		pwd = sc.next();

		vo.setId("test");
		vo.setPassword("test1234");

		UserVO user = us.getUser(vo);
		model.addAttribute("id", user.getId());
		model.addAttribute("name", user.getName());
		model.addAttribute("pwd", user.getPassword());
		model.addAttribute("role", user.getRole());
		if (user != null) {
			System.out.println(user.getName() + "님 환영합니다.");
		} else {
			System.out.println("로그인 실패");
		}

		return "home";
	}

}
