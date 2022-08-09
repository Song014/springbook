package com.springbook.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.JdbcUtill;

@Repository
public class BoardDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public void insertBoard(BoardVO vo) {
		String sql = "insert into board(seq,title,writer,content)values(board_seq.NEXTVAL,?,?,?)";
		try {
			conn = JdbcUtill.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally { 
			JdbcUtill.close(pstmt, conn);
		}
		
	}
	public void updateBoard(BoardVO vo) {
		
	}
	public void deleteBoard(BoardVO vo) {
		
	}
	public BoardVO getBoard(BoardVO vo) {
		
		
		return null;
	}
	public List<BoardVO> getBoardList() {
		
		
		return null;
	}
}
