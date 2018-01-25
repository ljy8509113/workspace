package database.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDB {
	public static void main(String[] args) {
		String driverName = "com.mysql.jdbc.Driver";
		String DBName = "world_0";
		String dbURL = "jdbc:mysql://localhost:3306/"+DBName;
		
		try {
			Class.forName(driverName);
			Connection con = DriverManager.getConnection(dbURL, "root", "koitt");
			
//			createTable(con);
			insert(con);
//			select(con);
//			dropTable(con);
			
		}catch(Exception e) {
			System.out.println("에러");
			System.out.println(e.getMessage());
		}
	}
	
	static void createTable(Connection con) {
		String query = "create table city("
				+ "id int auto_increment,"
				+ "name varchar(50) not null, "
				+ "major varchar(20), "
				+ "pop int(20), "
				+ "primary key (id)); ";
		try {
			Statement stmt = con.createStatement();//con.createStatement(query);
			stmt.executeUpdate(query);
			System.out.println("create table");
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void select(Connection con) {
		String sql = "select * from city";	
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);
			ResultSet result = pstmt.executeQuery();
			
			while(result.next()) {
				System.out.print(result.getString(1) + "\t");
				System.out.print(result.getString(2) + "\t");
				System.out.print(result.getInt(3) + "\t");
				System.out.println(result.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	static void insert(Connection con) {
		
//		String sql = "insert into city values(?,?,?)";
//		PreparedStatement pstmt;
		try {
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, "서울");
//			pstmt.setString(2, "이명길");
//			pstmt.setInt(3, 20000000);
//			pstmt.executeUpdate();
//			
//			pstmt.setString(1, "인천");
//			pstmt.setString(2, "김동훈");
//			pstmt.setInt(3, 3500000);
//			pstmt.executeUpdate();
//
//			pstmt.setString(1, "대구");
//			pstmt.setString(2, "강수복");
//			pstmt.setInt(3, 3000000);
//			pstmt.executeUpdate();
//			
//			pstmt.setString(1, "부산");
//			pstmt.setString(2, "남기문");
//			pstmt.setInt(3, 5000000);
//			
//			pstmt.executeUpdate();
//			pstmt.setString(1, "목포");
//			pstmt.setString(2, "신용현");
//			pstmt.setInt(3, 2000000);
//			pstmt.executeUpdate();
			
//			pstmt.close();
			
			Statement stmt = con.createStatement();
//			stmt.executeUpdate(query);
			
			stmt.executeUpdate("insert into city values('서울', '이명길', 20000000);");
			stmt.executeUpdate("insert into city values('인천', '김동훈', 3500000);");
			stmt.executeUpdate("insert into city values('대구', '강수복', 3000000);");
			stmt.executeUpdate("insert into city values('부산', '남기문', 5000000);");
			stmt.executeUpdate("insert into city values('목포', '신용현', 2000000);");
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	static void dropTable(Connection con) {
		String query = "drop table city;";
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);
			System.out.println("drop table");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
