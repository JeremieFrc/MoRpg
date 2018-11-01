package com.societe.projet.databases.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.societe.projet.databases.DBOUtilitaire;
import com.societe.projet.databases.DBOpenHelper;
import com.societe.projet.databases.contracts.armes.ArmeContract;
import com.societe.projet.databases.contracts.armes.ArmeMagiqueContract;
import com.societe.projet.databases.contracts.armes.ArmePhysiqueContract;

public class DAOManager {
	
	/**************************************\
    	@private
	\**************************************/
	
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	private PreparedStatement preparedStatement = null;
	
	private int status;
	
	/**************************************\
	     @Constructor
    \**************************************/
	
	public DAOManager () {
		System.out.println("connection at bdd");
		//recuperation de la connection fior utilisation
		connection = DBOpenHelper.getIntance().getConnection();
	}	
	
	/**************************************\
		@getter and Setter
	\**************************************/

	public Connection getConnection() {
		return connection;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	public Statement getStatement() {
		return statement;
	}
	public void setStatement(Statement statement) {
		this.statement = statement;
	}
	public ResultSet getResultSet() {
		return resultSet;
	}
	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}
	public PreparedStatement getPreparedStatement() {
		return preparedStatement;
	}
	public void setPreparedStatement(PreparedStatement preparedStatement) {
		this.preparedStatement = preparedStatement;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}	
	/**************************************\
		@Methods
	\**************************************/

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
		}finally {
			DBOUtilitaire.CloseStatement(statement);
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
		}finally {
			DBOUtilitaire.CloseStatement(statement);
		}
	}
	//temporaire
	public void initConstraintPrepaStat(String query1, String query2) {
		boolean returnKey = false;
		//String query = "INSERT INTO"
		for(int i=1;i<=6;i++) {
			if(i<4) {
				//tablen magique
				try {
					preparedStatement = DBOUtilitaire.initPreparedStatement(connection,query1,returnKey,i);
					preparedStatement.executeUpdate();
					System.out.println("init lien Magique");
				} catch (SQLException e) {
					System.out.println("error init lien physic");
					e.printStackTrace();
				}finally {
					DBOUtilitaire.closePreparedStatement(preparedStatement);
				}
			}else {
				try {
					//tablen physique
					preparedStatement = DBOUtilitaire.initPreparedStatement(connection,query2,returnKey,i);
					preparedStatement.executeUpdate();
					System.out.println("init lien physic");
				} catch (SQLException e) {
					System.out.println("error init lien physic");
					e.printStackTrace();
				}finally {
					DBOUtilitaire.closePreparedStatement(preparedStatement);
				}
			}
			
		}
	}
	
}
