package com.springbook.biz;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

public class BoardServiceClient {
	public static void main(String[] args) {

		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml"); // 싱글톤 패턴임

		BoardService bs = (BoardService) container.getBean("boardServiceImpl");
		
		
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			int seq = 0;
			String title = "";
			String writer = "";
			String Content = "";
			System.out.println("1.글 작성 2.글 수정 3,글 삭제 4.글 조회 5.전체 조회 0.종료");
			System.out.println("번호 입력:");
			int key = sc.nextInt();
			if (key == 1) {
				
				System.out.println("제목:");
				title = sc.next();
				System.out.println("작성자:");
				writer = sc.next();
				System.out.println("내용:");
				Content = sc.next();

				BoardVO vo = new BoardVO();
				
				vo.setTitle(title);
				vo.setWriter(writer);
				vo.setContent(Content);

				bs.insertBoard(vo);
			} else if (key == 2) {
				// update
				BoardVO vo = new BoardVO();
				System.out.println("수정할 글 번호 :");
				seq = sc.nextInt();
				System.out.println("수정할 제목 :");
				title = sc.next();

				System.out.println("수정할 내용 :");
				Content = sc.next();

				vo.setSeq(seq);
				vo.setTitle(title);
				vo.setContent(Content);
				bs.updateBoard(vo);
			} else if (key == 3) {
				// delete
				System.out.println("삭제할 글번호 :");
				int n = sc.nextInt();
				BoardVO vo = new BoardVO();
				vo.setSeq(n);
				bs.deleteBoard(vo);
			} else if (key == 4) {
				// getBoard
				System.out.println("조회할 글번호 :");
				int n = sc.nextInt();
				BoardVO vo = new BoardVO();
				vo.setSeq(n);
				BoardVO board = bs.getBoard(vo);
				System.out.println(board);
			} else if (key == 5) {
				// getList 전체조회
				List<BoardVO> list = bs.getBoardList();
				for (BoardVO list2 : list) {
					System.out.println(list2);
				}
			} else if (key == 0) {

				flag = false;
			}
		}
		System.out.println("끝");

		container.close();
	}
}
