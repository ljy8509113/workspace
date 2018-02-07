package com.koitt.java.board.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.koitt.java.board.dao.BoardDao;
import com.koitt.java.board.exception.BoardException;
import com.koitt.java.board.model.Board;

public class BoardService {
	
	private BoardDao dao;
	
	public BoardService() {
		this.dao = new BoardDao();
	}

	public void add(Board board) throws BoardException, SQLException {
		this.dao.insert(board);			// �옄猷뚭뎄議�(ArrayList)�뿉 ���옣�븯湲� �쐞�빐 dao濡� board 媛앹껜瑜� �쟾�떖
	}
	

	public List<Board> read() throws SQLException {
		return dao.selectAll();
	}
	
	public int remove(Board board) throws BoardException {
		return dao.delete(board);
	}
	
	public void modify(Board board) throws BoardException {
		board.setModiDate(new Date());
		dao.update(board);
	}
	
	public boolean isExist(int no) throws SQLException {
		return dao.isExist(no);
	}
}
