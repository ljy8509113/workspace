package com.koitt.java.board.util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.koitt.java.board.model.Board;

public class DBManager {
	public static final String URL = "jdbc:mysql://localhost:3306/";
	public static final String DB_NAME = "koitt";
	public static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
			
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private static DBManager instance = null;
	
	public static DBManager getInstance() {
		if(instance == null)
			instance = new DBManager();
		
		return instance;
	}
	
	private DBManager() {
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Board select(int no) throws SQLException {
		conn = DriverManager.getConnection(URL + DB_NAME, "root", "koitt");
		String sql = "select * from BOARD where no=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, no);
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			Board b = new Board(
					rs.getInt("no"),
					rs.getString("title"),
					rs.getString("content"),
					rs.getString("writer"),
					rs.getDate("regdate"),
					rs.getDate("modidate")
					);
			return b;
		}else {
			return null;
		}
	}
	
	public List<Board> selectAll() throws SQLException{
		conn = DriverManager.getConnection(URL + DB_NAME, "root", "koitt");
		String sql = "select * from BOARD";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<Board> list = new ArrayList<>();
		
		while(rs.next()) {
			Board b = new Board(
					rs.getInt("no"),
					rs.getString("title"),
					rs.getString("content"),
					rs.getString("writer"),
					rs.getDate("regdate"),
					rs.getDate("modidate")
					);
			list.add(b);
			
		}
		close();
		return list;
	}
	
	public void insert(Board board) throws SQLException {
		conn = DriverManager.getConnection(URL + DB_NAME, "root", "koitt");
		StringBuilder sql = new StringBuilder(); //"insert into BOARD(title, content, writer, regdate, modidate) valuses(?,?,?,?,?)";
		sql.append("insert into BOARD(title, content, writer, regdate, modidate) ");
		sql.append("values(?,?,?,CURDATE(),null)");
		
		pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, board.getTitle());
		pstmt.setString(2, board.getContent());
		pstmt.setString(3, board.getWriter());
		pstmt.executeUpdate();
		
		close();
		
	}
	
	public int update(Board board) throws SQLException {
//		update BOARD set title = 'title-', content='contents', modidate=CURDATE() where NO=3;
		conn = DriverManager.getConnection(URL + DB_NAME, "root", "koitt");
		StringBuilder sql = new StringBuilder(); //"insert into BOARD(title, content, writer, regdate, modidate) valuses(?,?,?,?,?)";
		sql.append("update BOARD set title=?, content=?, modidate=CURDATE() ");
		sql.append("where no=?");
		
		pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, board.getTitle());
		pstmt.setString(2, board.getContent());
		pstmt.setInt(3, board.getId());
		int result = pstmt.executeUpdate();
		
		close();		
		
		return result;
	}
	
	public int delete(Board board) throws SQLException {
		conn = DriverManager.getConnection(URL + DB_NAME, "root", "koitt");
		String sql = "delete from BOARD where no = ?";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, board.getId());
		int result = pstmt.executeUpdate();
		
		System.out.println("delete result : " + result);
		close();
		
		return result;
	}
	
	private void close() throws SQLException {
		if(rs != null) 
			rs.close();
		if(pstmt != null) 
			pstmt.close();
		if(pstmt != null) 
			conn.close();
	}
	
}
