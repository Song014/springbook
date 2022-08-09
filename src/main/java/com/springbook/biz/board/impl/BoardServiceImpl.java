package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO dao;
	
	@Override
	public void insertBoard(BoardVO vo) {
		
		dao.insertBoard(vo);

	}

	@Override
	public void updateBoard(BoardVO vo) {
		dao.updateBoard(vo);

	}

	@Override
	public void deleteBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		dao.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		
		return dao.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList() {
		
		return dao.getBoardList();
	}

}
