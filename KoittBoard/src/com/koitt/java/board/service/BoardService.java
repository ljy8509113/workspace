package com.koitt.java.board.service;

import java.util.Date;
import java.util.List;

import com.koitt.java.board.dao.BoardDao;
import com.koitt.java.board.exception.BoardException;
import com.koitt.java.board.model.Board;

public class BoardService {
	
	private BoardDao dao;
//	private Integer count;	// �⺻���� null �̱� ������ �����ڿ��� 0���� �ʱ�ȭ�ؾ� �Ѵ�.
	
	public BoardService() {
		this.dao = new BoardDao();
//		this.count = 0;	// 0���� �ʱ�ȭ
	}
	
								// 3.
	public void add(Board board) throws BoardException {
		board.setId(this.dao.makeIndex());		// null���̾��� id���� ä���ش�.
		board.setRegDate(new Date());	// new Date() �ϴ� ������ �ð��� ����ȴ�.
		this.dao.insert(board);			// �ڷᱸ��(ArrayList)�� �����ϱ� ���� dao�� board ��ü�� ����
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
