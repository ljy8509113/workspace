package database.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectTable {
	public static void main(String[] args) {
		try {
			String driverName = "com.mysql.jdbc.Driver";
			String dbName = "myjavadb";
			String dbURL = "jdbc:mysql://localhost:3306/" + dbName;
			String sql = "select * from student";
			
			Class.forName(driverName);
			Connection con = DriverManager.getConnection(dbURL, "root", "koitt");
			
			Statement stmt = con.createStatement();
			
			ResultSet result = stmt.executeQuery(sql);
			while(result.next()) {
				System.out.print(result.getString(1) + "\t");
				System.out.print(result.getString(2) + "\t");
				System.out.print(result.getInt(3) + "\t");
				System.out.println(result.getString(4));
			}
			con.close();
			
		}catch(Exception e) {
			System.out.println("문제발생");
		}
	}
}
