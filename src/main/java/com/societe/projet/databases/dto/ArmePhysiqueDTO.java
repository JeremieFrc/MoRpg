package com.societe.projet.databases.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.societe.projet.databases.contracts.armes.ArmeContract;
import com.societe.projet.entities.armes.ArmePhysique;

public class ArmePhysiqueDTO implements DTO<ArmePhysique> {

	/*
	*************************************************
	*    @Methods Override
	*************************************************
	*/	
	@Override
	public String javaToMySQL(ArmePhysique item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArmePhysique mySQLToJava(ResultSet rs) throws SQLException {
		ArmePhysique arme = new ArmePhysique();
		
		arme.setNom(rs.getString(rs.findColumn(ArmeContract.FIELDS[1])));
		arme.setDegat(rs.getInt(rs.findColumn(ArmeContract.FIELDS[2])));
		arme.setCpa(rs.getInt(rs.findColumn(ArmeContract.FIELDS[3])));
		
		return arme;
	}

	

}
