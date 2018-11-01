package com.societe.projet.databases.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface DTO <T> {
	
	String javaToMySQL(T item); // object in String
	T mySQLToJava(ResultSet rs) throws SQLException; //method recup info in object
}
