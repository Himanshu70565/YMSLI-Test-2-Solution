package com.customerapp.dao.factory;

import java.sql.Connection;

public class TestConnectionFactory {
	public static void main(String[] args) {
		Connection connection=ConnectionFactory.getConnection();
		if(connection!=null) {
			System.out.println("connection created");
		}
	}
}
