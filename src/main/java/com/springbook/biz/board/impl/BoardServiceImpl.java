package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAOSpring dao;

	@Override
	public void insertBoard(BoardVO vo) {
//		 if(vo.getSeq() == 0) {
//	         throw new IllegalArgumentException("0번 게시물은 등록할 수 없습니다.");
//	      }
		dao.insertBoard(vo);
		dao.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {

		dao.updateBoard(vo);

	}

	@Override
	public void deleteBoard(BoardVO vo) {

		dao.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {

		return dao.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList() {

		return dao.getBoardList();
	}

}
