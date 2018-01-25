package database.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {
	public static void main(String[] args) {
		try {
			String driverName = "com.mysql.jdbc.Driver";
			String DBName = "myjavadb";
			String dbURL = "jdbc:mysql://localhost:3306/"+DBName;
			
			String sqlCT = "create table student(" +
			"id varchar(20) not null, name varchar(20) not null, sum int not null, dept varchar(20) not null, PRIMARY KEY(id));";
			
			Class.forName(driverName);
			Connection con = DriverManager.getConnection(dbURL, "root", "koitt");
			
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sqlCT);
			
			stmt.executeUpdate("insert into student values('01', '홍길동', 20125678, '전산학과');");
			stmt.executeUpdate("insert into student values('02', '김제동', 20125678, '미생물학과');");
			stmt.executeUpdate("insert into student values('03', '김지숙', 20125678, '고고학과');");
					
			System.out.println("insert 3");
			con.close();
		}catch(Exception e) {
			System.out.println("DB error");
			System.out.println(e.getMessage());
		}
	}
}
