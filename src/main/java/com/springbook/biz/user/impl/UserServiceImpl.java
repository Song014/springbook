package com.springbook.biz.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;

@Service
public class UserServiceImpl implements UserService {
	
	
	
//	@Setter(onMethod = @__({@Autowired}))
	@Autowired
	private UserDAO dao;
	
	@Override
	public void insertUser(UserVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(UserVO vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(UserVO vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public UserVO getUser(UserVO vo) {
		// TODO Auto-generated method stub
		System.out.println("==== service 기능처리");
		return dao.getUser(vo);
	}

	@Override
	public List<UserVO> getUserList() {
		// TODO Auto-generated method stub
		return dao.getUserList();
	}

}
