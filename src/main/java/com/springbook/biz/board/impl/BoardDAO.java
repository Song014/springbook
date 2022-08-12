package com.springbook.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.JdbcUtill;

@Repository
public class BoardDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private final String BOARD_INSERT = "INSERT INTO board(seq,title,writer,content)"
			+ "VALUES((SELECT nvl(max(seq),0)+1 FROM board),?,?,?)";
	private final String BOARD_UPDATE = "UPDATE board SET title=?, content=? WHERE seq = ?";
	private final String BOARD_DELETE = "DELETE FROM board WHERE seq = ?";
	private final String BOARD_GET = "SELECT * FROM board WHERE seq = ?";
	private final String BOARD_LIST = "SELECT * FROM board order by seq desc";
	private final String BOARD_CNT = "update board set cnt=cnt+1 where seq=?";

	public void insertBoard(BoardVO vo) {
		try {
			System.out.println("====== insertBoard 기능처리");
			conn = JdbcUtill.getConnection();
			pstmt = conn.prepareStatement(BOARD_INSERT);
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
		try {
			System.out.println("====== updateBoard 기능처리");
			conn = JdbcUtill.getConnection();
			pstmt = conn.prepareStatement(BOARD_UPDATE);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getSeq());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtill.close(pstmt, conn);
		}
	}

	public void deleteBoard(BoardVO vo) {
		try {
			System.out.println("====== deleteBoard 기능처리");
			conn = JdbcUtill.getConnection();
			pstmt = conn.prepareStatement(BOARD_DELETE);
			pstmt.setInt(1, vo.getSeq());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtill.close(pstmt, conn);
		}
	}

	public BoardVO getBoard(BoardVO vo) {
		BoardVO board = null;
		
		System.out.println("====== getBoard 기능처리");
		try {
			conn = JdbcUtill.getConnection();
			
			pstmt = conn.prepareStatement(BOARD_CNT);
			pstmt.setInt(1, vo.getSeq());
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement(BOARD_GET);
			pstmt.setInt(1, vo.getSeq());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				board = new BoardVO(); 
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getDate("regdate"));
				board.setCnt(rs.getInt("cnt"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtill.close(rs,pstmt, conn);
		}
		return board;
	}

	public List<BoardVO> getBoardList() {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		try {
			System.out.println("====== getBoardList 기능처리");
			conn = JdbcUtill.getConnection();
			pstmt = conn.prepareStatement(BOARD_LIST);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO board = new BoardVO(); 
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getDate("regdate"));
				board.setCnt(rs.getInt("cnt"));
				boardList.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtill.close(rs,pstmt, conn);
		}
		return boardList;
	}
}
