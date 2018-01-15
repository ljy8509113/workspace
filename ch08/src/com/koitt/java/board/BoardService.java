package com.koitt.java.board;

import java.util.Map;

import person.MyException;

public class BoardService {
	private BoardDao dao;
	private int index = 0;
	
	public BoardService() {
		this.dao = new BoardDao();
	}
	
	public void add(Board b) throws MyException {
		b.setId(++index);
		dao.insert(b);
	}
	
	public Map<Integer, Board> selectAll() throws MyException {
		return dao.selectAll();
	}
	
	public Board select(int id) throws MyException{
		return dao.select(id);
	}
	
	public void remove(int id) throws MyException {
		this.dao.remove(id);
	}
	
	public void update(Board b) throws MyException{
		this.dao.update(b);
	}
	
	public int getIndex() {
		return index;
	}
}
