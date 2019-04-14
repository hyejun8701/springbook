package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

	public static void main(String[] args) {
		// 1. Spring 컨테이너 구동
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring 컨테이너로 부터 필요한 객체 요청(lookup)
		BoardService boardService = (BoardService) container.getBean("boardServiceImpl");
		
		BoardVO vo = new BoardVO();
		vo.setTitle("임시 제목");
		vo.setWriter("홍길동");
		vo.setContent("임시 내용......");
		boardService.insertBoard(vo);

		List<BoardVO> boardList = boardService.getBoardList(vo);
		for(BoardVO board: boardList) {
			System.out.println("---> " + board.toString());
		}
		
		container.close();

	}

}
