package com.societe.projet.databases;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DBOpenHelper {
	
	/*
	*************************************************
	*    @Constante
	*************************************************
	 */
	
	public static final String URL = "root@localhost";
	public static final String DATA_BASE = "myrpg";
	public static final String SERVERNAME = "127.0.0.1";
	public static final String USER = "root";
	public static final String PASS = "";
	
	/*
	*************************************************
	*    @Private
	*************************************************
	 */
	
	private Connection connection;
	
	/*
	*************************************************
	*    @Constructor
	*************************************************
	 */
	
	private DBOpenHelper () {
		/*
		 * init datasource de constitier pull de connection
		 * object permettant regroupent de connexion 
		 * et des transastion distribuer
		 */
		MysqlDataSource dataSource = new MysqlDataSource();
		
		dataSource.setDatabaseName(DATA_BASE);
		dataSource.setServerName(SERVERNAME);
		dataSource.setUser(USER);
		dataSource.setPassword("");
		
		//init timezone
		dataSource.setServerTimezone("UTC");
		
		try {
			connection = dataSource.getConnection();
			//System.out.println("connection realiser");
		} catch (SQLException e) {
			System.out.println("error de connection");
			e.printStackTrace();
		}
	}
	/*
	*************************************************
	*    @Singleton
	*************************************************
	 */
	
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
