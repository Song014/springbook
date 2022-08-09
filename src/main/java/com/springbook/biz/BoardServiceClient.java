package com.springbook.biz;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

public class BoardServiceClient {
	public static void main(String[] args) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		BoardService bs = (BoardService)container.getBean("boardServiceImpl");
		// insert
//		BoardVO vo = new BoardVO();
//		vo.setTitle("테스트제목");
//		vo.setWriter("송기석");
//		vo.setContent("테스트 내용");
//		
//		bs.insertBoard(vo);
		
		
		// update
//		BoardVO vo = new BoardVO();
//		vo.setSeq(1);
//		vo.setTitle("테스a");
//		vo.setContent("테스s");
//		
//		bs.updateBoard(vo);
		// delete
//		BoardVO vo = new BoardVO();
//		vo.setSeq(4);
//		bs.deleteBoard(vo);
		// getBoard
		BoardVO vo = new BoardVO();
		vo.setSeq(3);
		BoardVO board = bs.getBoard(vo);
		System.out.println(board);
		// getList
//		List<BoardVO> list = boardService.getBoardList();
//		for(BoardVO list2 : list) {
//			System.out.println(list2);
//		}
		
		container.close();
	}
}
