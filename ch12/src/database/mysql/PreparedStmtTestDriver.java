package database.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PreparedStmtTestDriver {
	public static void main(String[] args) {
		String driverName = "com.mysql.jdbc.Driver";
		String DBName = "myjavadb";
		String dbURL = "jdbc:mysql://localhost:3306/"+DBName;
		
		try {
			Class.forName(driverName);
			Connection con = DriverManager.getConnection(dbURL, "root", "koitt");
			
			String sql = "select * from student";	
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			ResultSet result = pstmt.executeQuery();
			
			while(result.next()) {
				System.out.print(result.getString(1) + "\t");
				System.out.print(result.getString(2) + "\t");
				System.out.print(result.getInt(3) + "\t");
				System.out.println(result.getString(4));
			}
			
			result.close();
			pstmt.close();
//			con.close();
			
			sql = "insert into student values(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "04");
			pstmt.setString(2, "고길동");
			pstmt.setInt(3, 2012312);
			pstmt.setString(4, "컴퓨터 공학과");
			pstmt.executeUpdate();
			pstmt.close();
			
		}catch(Exception e) {
			System.out.println("에러");
			System.out.println(e.getMessage());
		}
	}
}
