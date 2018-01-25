package database.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableWORLD {
	public static void main(String[] args) {
		
		String driverName = "com.mysql.jdbc.Driver";
		String DBName = "world_0";
		String dbURL = "jdbc:mysql://localhost:3306";
		
		String query = "create table city(id int(5) auto_increment, name varchar(50) not null, major varchar(20), pop int, primary key (id); ";
		try {
			Class.forName(driverName);
			Connection con = DriverManager.getConnection(dbURL, "root", "koitt");
		
			Statement stmt = con.createStatement();
			stmt.executeUpdate("CREATE DATABASE world_0;");
			
//			stmt.executeUpdate(query);
			System.out.println("¼º°ø");
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
}
