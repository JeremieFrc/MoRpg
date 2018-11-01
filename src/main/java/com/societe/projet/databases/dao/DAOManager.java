package com.societe.projet.databases.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.societe.projet.databases.DBItem;
import com.societe.projet.databases.DBOUtilitaire;
import com.societe.projet.databases.DBOpenHelper;
import com.societe.projet.databases.contracts.Contract;
import com.societe.projet.databases.dto.DTO;


public class DAOManager <T extends DBItem >{
	
	/***************************************
	*  @private
	* ***************************************/	
	
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	private PreparedStatement preparedStatement = null;
	
	private int status;
	
   /***************************************
	*  @Constructor
	* ***************************************/
	public DAOManager () {
		System.out.println("connection at bdd");
		//recuperation de la connection fior utilisation
		connection = DBOpenHelper.getIntance().getConnection();
	}	

	/* **************************************
	 *  @getter and @Setter
	 * ***************************************/

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
	
	/*
	 * **************************************
	 *  @Methods
	 * ***************************************/

	public void createTable(String query) {	
		//init
			try {
				statement = connection.createStatement();
				statement.executeUpdate(query);
				System.out.println("create ok");
				
			} catch (SQLException e) {
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
			System.out.println("error drop");
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
	
	public void initConstraintPrepaStat(String query1,int debut,int fin) {
		boolean returnKey = false;
		//String query = "INSERT INTO"
		for(int i=debut;i<fin;i++) {
			
				try {
					preparedStatement = DBOUtilitaire.initPreparedStatement(connection,query1,returnKey,i);
					preparedStatement.executeUpdate();
					System.out.println("init lien Magique");
				} catch (SQLException e) {
					System.out.println("error init lien Magic");
					e.printStackTrace();
				}finally {
					DBOUtilitaire.closePreparedStatement(preparedStatement);
				}
			
			}
			
		
	}
	
	
	

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
					System.out.println("error init lien Magic");
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
	
	/*
	 * **************************************
	 *  @Methods
	 * ***************************************/
	
	
	
	public ArrayList<T> selectAllJoin(Contract contract, DTO<T> dto) {
		
		ArrayList<T> result = new ArrayList<T>();
		
		StringBuilder request = new StringBuilder();
		request.append("SELECT ");
		request.append(contract.getSelectTable());
		request.append(" FROM ");
		request.append(contract.getTable());
		request.append(contract.getInnerJoin());
		
		System.out.println(request.toString());
		
		parser(dto, result, request);
		return result;
	}
	
	private void parser(DTO<T> dto, ArrayList<T> result, StringBuilder request) {
	
		try {
			//stmt = DBOpenHelper.getInstance().getConn().createStatement();
			preparedStatement = DBOUtilitaire.initPreparedStatement(connection, request.toString());
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				result.add(dto.mySQLToJava(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
