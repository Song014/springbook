package com.springbook.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springbook.biz.common.JdbcUtill;
import com.springbook.biz.user.UserVO;

@Repository
public class UserDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private final String USER_GET = "select * from users where id =? and password=?";
	private final String USER_LIST = "select * from users";
	
	public UserVO getUser(UserVO vo) {
		UserVO user = null;
		
		try {
			conn = JdbcUtill.getConnection();
			pstmt = conn.prepareStatement(USER_GET);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
				System.out.println("==== dao 기능처리");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;	
	}
	public List<UserVO> getUserList() {
		List<UserVO> list = new ArrayList<UserVO>();
		try {
			conn = JdbcUtill.getConnection();
			pstmt = conn.prepareStatement(USER_LIST);			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				UserVO user = new UserVO();
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
				list.add(user);
				System.out.println(user +"====DAO");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
