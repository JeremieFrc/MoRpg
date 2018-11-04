package com.societe.projet.databases.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.societe.projet.databases.contracts.armes.ArmeContract;
import com.societe.projet.entities.armes.ArmeMagique;

public class ArmeMagiqueDTO implements DTO<ArmeMagique> {

	
	/*
	*************************************************
	*    @Methods Override
	*************************************************
	*/	
	
	@Override 
	public String javaToMySQL(ArmeMagique item) {
		//Potentiel insert Data bdd
		return null;
	}

	@Override
	public ArmeMagique mySQLToJava(ResultSet rs) throws SQLException {
		ArmeMagique arme = new ArmeMagique();
		
		arme.setNom(rs.getString(rs.findColumn(ArmeContract.FIELDS[1])));
		arme.setDegat(rs.getInt(rs.findColumn(ArmeContract.FIELDS[2])));
		arme.setCpa(rs.getInt(rs.findColumn(ArmeContract.FIELDS[3])));
		
		return arme;
	}
}
