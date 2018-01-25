package database.mysql;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
	public static void main(String[] args) {
		try {
			String driverName = "com.mysql.jdbc.Driver";
			Class.forName(driverName);
			String dbURL = "jdbc:mysql://localhost:3306";
			Connection conn = DriverManager.getConnection(dbURL, "root", "koitt");
			System.out.println("접속 성공");
			conn.close();
		}catch(Exception e) {
			
		}
	}
}
