package com.societe.projet.databases.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.societe.projet.databases.contracts.armures.ArmureContract;
import com.societe.projet.entities.armures.ArmureMagique;

public class ArmureMagiqueDTO implements DTO<ArmureMagique> {

	@Override
	public String javaToMySQL(ArmureMagique item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArmureMagique mySQLToJava(ResultSet rs) throws SQLException {
		ArmureMagique arme = new ArmureMagique();
		
		arme.setNom(rs.getString(rs.findColumn(ArmureContract.FIELDS[1])));
		arme.setDefence(rs.getInt(rs.findColumn(ArmureContract.FIELDS[2])));
		
		return arme;
	}

}
