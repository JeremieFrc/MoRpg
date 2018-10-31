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
	
	public void createArmeTable() {
		//test insert base dans 
		String query  = ArmeContract.CREATE_TABLE;
		
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
	public void dropTable() {
		try {
			statement = connection.createStatement();
			statement.executeUpdate(ArmeContract.DROP_TABLE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
