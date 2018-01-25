package com.koitt.java.board;

import java.util.HashMap;
import java.util.Map;

import person.MyException;

public class BoardDao {
	Map<Integer, Board> map = null;
	
	public BoardDao() {
		map = new HashMap<>();
	}
	
	public void insert(Board b) {
		map.put(b.getId(), b);
	}
	
	public Map<Integer, Board> selectAll() throws BoardException {
		if(map.size() == 0)
			throw new BoardException(Common.MSG_SELECT_FAIL);
		else
			return map;
	}
	
	public Board select(int index) throws BoardException{
		Board item = map.get(index);
		if(item == null)
			throw new BoardException(Common.MSG_SELECT_FAIL);
		else
			return item;
	}
	
	public void delete(int index) throws BoardException{
		Board item = map.get(index);
		if(item == null)
			throw new BoardException(Common.MSG_DELETE_FAIL);
		else
			map.remove(index);		
	}
	
	public void update(Board b) throws BoardException{
		Board item = map.get(b.getId());
		if(item == null)
			throw new BoardException(Common.MSG_MODIFY_FAIL);
		else
			map.put(b.getId(), b);
	}
	
	public int getCount() {
		return map.size();
	}
	

	
}
