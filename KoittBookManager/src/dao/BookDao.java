package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import vo.Book;

public class BookDao {
	
	public List<Book> selectAll() throws ClassNotFoundException, SQLException{
		Connection db = DBUtil.getInstance().getConnection();
		
		String sql = "select * from book order by isbn desc";
		PreparedStatement pstmt = db.prepareStatement(sql);
		
		ResultSet res = pstmt.executeQuery();
		List<Book> list = new ArrayList<Book>();
		while(res.next()) {
			Book b = new Book();
			b.setIsbn(res.getInt("isbn"));
			b.setTitle(res.getString("title"));
			b.setAuthor(res.getString("author"));
			b.setPublicsher(res.getString("publicsher"));
			b.setPrice(res.getInt("price"));
			b.setDescription(res.getString("description"));
			list.add(b);
		}
		
		DBUtil.getInstance().close(res, pstmt, db);
		return list;
	}
	
	public Book select(Integer isbn) throws ClassNotFoundException, SQLException {
		Connection conn = DBUtil.getInstance().getConnection();
		
		String sql = "select * from book where isbn=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, isbn);
		
		ResultSet res = pstmt.executeQuery();
		Book b = new Book();
		
		res.next();
		b.setIsbn(res.getInt("isbn"));
		b.setTitle(res.getString("title"));
		b.setAuthor(res.getString("author"));
		b.setPublicsher(res.getString("publicsher"));
		b.setPrice(res.getInt("price"));
		b.setDescription(res.getString("description"));		
		
		DBUtil.getInstance().close(res, pstmt, conn);
		return b;
	}
	
	public void insert(Book board) throws SQLException, ClassNotFoundException {
		Connection conn = DBUtil.getInstance().getConnection();
		String sql = "insert into book(title, author, publicsher, price, description) values(?,?,?,?,?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, board.getTitle());
		pstmt.setString(2, board.getAuthor());
		pstmt.setString(3, board.getPublicsher());
		pstmt.setInt(4, board.getPrice());
		pstmt.setString(5, board.getDescription());
		
		pstmt.executeUpdate();
		DBUtil.getInstance().close(null, pstmt, conn);		
	}
	
	public void delete(Integer isbn) throws ClassNotFoundException, SQLException {
		Connection conn = DBUtil.getInstance().getConnection();
		String sql = "delete from book where isbn=?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, isbn);
		pstmt.executeUpdate();
		DBUtil.getInstance().close(null, pstmt, conn);	
	}
	
	public void update(Book board) throws SQLException, ClassNotFoundException {
		Connection conn = DBUtil.getInstance().getConnection();
		String sql = "update book set title=?, author=?, publicsher=?, price=?, description=? where isbn=?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, board.getTitle());
		pstmt.setString(2, board.getAuthor());
		pstmt.setString(3, board.getPublicsher());
		pstmt.setInt(4, board.getPrice());
		pstmt.setString(5, board.getDescription());
		pstmt.setInt(6, board.getIsbn());
		
		pstmt.executeUpdate();
		DBUtil.getInstance().close(null, pstmt, conn);		
	}
	
}
