package com.koitt.java.board;

import java.util.Map;

public class BoardService {
	private BoardDao dao;
	private int index = 0;
	
	public BoardService() {
		this.dao = new BoardDao();
	}
	
	public void add(Board b) throws BoardException {
		b.setId(++index);
		dao.insert(b);
	}
	
	public Map<Integer, Board> selectAll() throws BoardException {
		return dao.selectAll();
	}
	
	public Board select(int id) throws BoardException{
		return dao.select(id);
	}
	
	public void remove(int id) throws BoardException {
		this.dao.delete(id);
	}
	
	public void modify(Board b) throws BoardException{
		this.dao.update(b);
	}
	
	public int getIndex() {
		return index;
	}
}
