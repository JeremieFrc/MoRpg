package com.societe.projet.databases;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DBOpenHelper {
	
	public static final String URL = "root@localhost";
	public static final String DATA_BASE = "bddmorpg";
	public static final String ServerName = "127.0.0.1";
	public static final String USER = "root";
	public static final String PASS = "";
	
	private Connection connection;
	
	private DBOpenHelper () {
		/*
		 * init datasource de constitier pull de connection
		 * object permettant regroupent de connexion 
		 * et des transastion distribuer
		 */
		MysqlDataSource dataSource = new MysqlDataSource();
		
		dataSource.setDatabaseName(DATA_BASE);
		dataSource.setServerName(ServerName);
		dataSource.setUser(USER);
		dataSource.setPassword("");
		
		//init timezone
		dataSource.setServerTimezone("UTC");
		
		try {
			connection = dataSource.getConnection();
			System.out.println("connection realiser");
		} catch (SQLException e) {
			System.out.println("error de connection");
			e.printStackTrace();
		}
	}
	
	private static DBOpenHelper INSTANCE = null;
	
	public static synchronized DBOpenHelper getIntance() {
		
		if (INSTANCE == null ) {
			INSTANCE = new DBOpenHelper();
		}
		return INSTANCE;
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	
	
}
