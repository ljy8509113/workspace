package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	private static DBUtil instance = null;
	
	public static DBUtil getInstance() {
		if(instance == null)
			instance = new DBUtil();
		
		return instance;
	}
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306";
		String dbName = "bookmgr";
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(url+"/"+dbName, "root","koitt");
		return con;
	}
	
	public void close(ResultSet result, Statement stmt, Connection con) throws SQLException {
		close(result);
		close(stmt);
		close(con);
	}
	
	public void close(Connection con) throws SQLException {
		if(con != null)
			con.close();
	}
	
	public void close(Statement stmt) throws SQLException {
		if(stmt != null)
			stmt.close();
	}
	
	public void close(ResultSet result) throws SQLException {
		if(result != null)
			result.close();
	}
	
	public void rollback(Connection con) throws SQLException {
		if(con != null)
			con.rollback();
	}
}
