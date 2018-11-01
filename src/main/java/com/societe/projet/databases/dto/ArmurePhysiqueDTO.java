package com.societe.projet.databases.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.societe.projet.databases.contracts.armures.ArmureContract;
import com.societe.projet.entities.armures.ArmurePhysique;

public class ArmurePhysiqueDTO implements DTO<ArmurePhysique> {

	@Override
	public String javaToMySQL(ArmurePhysique item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArmurePhysique mySQLToJava(ResultSet rs) throws SQLException {
		ArmurePhysique arme = new ArmurePhysique();
		
		arme.setNom(rs.getString(rs.findColumn(ArmureContract.FIELDS[1])));
		arme.setDefence(rs.getInt(rs.findColumn(ArmureContract.FIELDS[2])));
		
		return arme;
	}

}
