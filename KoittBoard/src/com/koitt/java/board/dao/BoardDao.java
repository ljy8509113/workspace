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
	
	public int delete(Board board) throws BoardException {
		try {
			if(DBManager.getInstance().delete(board) == 1)
				return 1;
			else
				throw new BoardException("E02: ������ �Խñ��� �������� �ʽ��ϴ�.");
		}catch(SQLException e) {
			throw new BoardException("E02: ������ �Խñ��� �������� �ʽ��ϴ�.");
		}
	}
	
	public int update(Board board) throws BoardException {
		try {
			if(DBManager.getInstance().update(board) == 1)
				return 1;
			else
				throw new BoardException("E03: ������ �Խñ��� �������� �ʽ��ϴ�.");
		}catch(SQLException e) {
			throw new BoardException(e.getMessage());
		}
		
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
