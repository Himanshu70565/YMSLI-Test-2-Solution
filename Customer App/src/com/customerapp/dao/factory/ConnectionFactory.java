package com.customerapp.dao.factory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	private static Connection connection = null;

	public ConnectionFactory() {
	}

	public static Connection getConnection() {
		
		InputStream inStream = ConnectionFactory.class.getClassLoader().getResourceAsStream("db.properties");

		Properties properties = new Properties();
		try {
			properties.load(inStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		String driverName = properties.getProperty("jdbc.driverName");
		String url = properties.getProperty("jdbc.url");
		String username = properties.getProperty("jdbc.username");
		String password = properties.getProperty("jdbc.password");

		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}

}
