package com.societe.projet.databases.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;
import com.societe.projet.databases.DBOUtilitaire;
import com.societe.projet.databases.DBOpenHelper;
import com.societe.projet.databases.contracts.armes.ArmeContract;

public class DAOManager {
	
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	private PreparedStatement preparedStatement = null;
	
	private int status;
	
	public DAOManager () {
		System.out.println("connection at bdd");
		//recuperation de la connection fior utilisation
		connection = DBOpenHelper.getIntance().getConnection();
	}
	
	public void createTable(String query) {
		//test insert base dans 
		//String query  = ArmeContract.CREATE_TABLE;
		
		//init
			try {
				statement = connection.createStatement();
				statement.executeUpdate(query);
				
				System.out.println("create ok");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				DBOUtilitaire.CloseStatement(statement);
			}
	}
	public void dropTable(String query) {
		try {
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insertBdd(String query) {
		try {
			statement = connection.createStatement();
			statement.executeUpdate(query);
			System.out.println("insert ok");
		} catch (SQLException e) {
			System.out.println("error insert");
			e.printStackTrace();
		}
		
	}

	public void closeConnection() {
		if(connection != null ) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
