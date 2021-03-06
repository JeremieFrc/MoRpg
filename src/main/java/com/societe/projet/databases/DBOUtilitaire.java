package com.societe.projet.databases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBOUtilitaire {
	
	/*
	*************************************************
	*    @PreparedStatement  QUERY STRING
	*************************************************
	 */
	
	public static PreparedStatement initPreparedStatement(Connection connect,String query) throws SQLException {
		PreparedStatement preparedStatement = connect.prepareStatement(query);
		return preparedStatement;	
	}
	/*
	*************************************************
	*    @PreparedStatement  generic
	*************************************************
	 */
	
	public static PreparedStatement initPreparedStatement
		(Connection connect, String query,boolean returnGeneratedKeys,Object...objects) throws SQLException {
		
		PreparedStatement preparedStatement = connect.prepareStatement
				(query,returnGeneratedKeys ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS);
		
		//init object on preparedStatement pour realiser  setX(parameter)
		for(int i=0;i<objects.length;i++) {
			
			//ajout element joker requete preparedStatement
			preparedStatement.setObject(i+1,objects[i]);
		}
		return preparedStatement;
	}
	
	/*
	*************************************************
	*    @Closer
	*************************************************
	 */

	public static void closeResultSet (ResultSet resultSet) {
		try {
			resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void CloseStatement(Statement statement) {
		try {
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void closePreparedStatement(PreparedStatement preparedStatement) {
		try {
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void closeConnection(Connection connect) {
		try {
			connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
