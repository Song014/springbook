package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;


public class BoardDAOSpring {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	private final String BOARD_INSERT = "INSERT INTO board(seq,title,writer,content)"
			+ "VALUES((SELECT nvl(max(seq),0)+1 FROM board),?,?,?)";
	private final String BOARD_UPDATE = "UPDATE board SET title=?, content=? WHERE seq = ?";
	private final String BOARD_DELETE = "DELETE FROM board WHERE seq = ?";
	private final String BOARD_GET = "SELECT * FROM board WHERE seq = ?";
	private final String BOARD_LIST = "SELECT * FROM board order by seq desc";
	private final String BOARD_CNT = "update board set cnt=cnt+1 where seq=?";
	
	public void insertBoard(BoardVO vo) {
		jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
	}

	public void updateBoard(BoardVO vo) {
		jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	}

	public void deleteBoard(BoardVO vo) {
		jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
	}

	public BoardVO getBoard(BoardVO vo) {
		Object[] args = { vo.getSeq() };
		jdbcTemplate.update(BOARD_CNT, vo.getSeq() );
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
	}

	public List<BoardVO> getBoardList() {
		
		return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
	}
}
