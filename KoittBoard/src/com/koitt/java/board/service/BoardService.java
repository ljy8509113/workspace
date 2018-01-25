package com.koitt.java.board.service;

import java.util.Date;
import java.util.List;

import com.koitt.java.board.dao.BoardDao;
import com.koitt.java.board.exception.BoardException;
import com.koitt.java.board.model.Board;

public class BoardService {
	
	private BoardDao dao;
//	private Integer count;	// 기본값이 null 이기 때문에 생성자에서 0으로 초기화해야 한다.
	
	public BoardService() {
		this.dao = new BoardDao();
//		this.count = 0;	// 0으로 초기화
	}
	
								// 3.
	public void add(Board board) throws BoardException {
		board.setId(this.dao.makeIndex());		// null값이었던 id값을 채워준다.
		board.setRegDate(new Date());	// new Date() 하는 순간의 시간이 저장된다.
		this.dao.insert(board);			// 자료구조(ArrayList)에 저장하기 위해 dao로 board 객체를 전달
	}
	
	// 2.
	public List<Board> read() {
		return dao.selectAll();
	}
	
	// 2.							// 3.
	public void remove(Board board) throws BoardException {
		dao.delete(board);
	}
	
	// 2.							// 3.
	public void modify(Board board) throws BoardException {
		board.setModiDate(new Date());	// 9.
		dao.update(board);
	}
	
	// 2.
	public boolean isExist(Board board) {
		return dao.isExist(board);
	}
}
