package com.koitt.java.board.dao;

import java.sql.SQLException;
import java.util.List;

import com.koitt.java.board.exception.BoardException;
import com.koitt.java.board.model.Board;
import com.koitt.java.board.util.DBManager;

public class BoardDao {
	
	public BoardDao() {}

	public void insert(Board board) throws BoardException, SQLException {
		DBManager.getInstance().insert(board);
	}
	
	public List<Board> selectAll() throws SQLException {
		return DBManager.getInstance().selectAll();
	}
	
	public void delete(Board board) throws BoardException {
		
		throw new BoardException("E02: ������ �Խñ��� �������� �ʽ��ϴ�.");
	}
	
	public void update(Board board) throws BoardException {
		
		throw new BoardException("E03: ������ �Խñ��� �������� �ʽ��ϴ�.");
	}
	
	// 1. �ش� ���� �����ϴ��� ���� Ȯ�� �޼ҵ�
	public boolean isExist(int no) throws SQLException {
//		return false;	// �� ã�ƺôµ� ��� false ����
		if(DBManager.getInstance().select(no) != null)
			return true;
		else
			return false;
	}
}
