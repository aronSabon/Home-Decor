package com.islington.decor.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

	public static Connection connectDatabase() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/islington-home-decor", "root", "root");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
