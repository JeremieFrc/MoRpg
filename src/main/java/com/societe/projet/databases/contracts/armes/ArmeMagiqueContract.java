package com.societe.projet.databases.contracts.armes;

import com.societe.projet.databases.contracts.Contract;

public class ArmeMagiqueContract implements Contract {
	
	/********* DESCRIPTION ELEMENT TABLE **************/

	public static final String   TABLE    = "armemagique";
	public static final String[] FIELDS = {"id","nom","degat","cpa"};
	public static final String   FOREIGN  = "fk_armemagique_arme";
	public static final String SELECT_FIELDS = TABLE+"."+FIELDS[0] 
			+ "," + FIELDS[1] 
			+ "," + FIELDS[2]
			+ "," + FIELDS[3];
	
	/********* Creation constraint and Drop **************/
	
	public static final String CREATE_TABLE =
			"CREATE TABLE " + TABLE + "(" +FIELDS[0] + " INT " + " NOT NULL "+
			") ENGINE=InnoDB DEFAULT CHARSET=UTF8 ";
	
	public static final String CREATE_TABLE_V2 = 
			"CREATE TABLE " + TABLE + "(" +FIELDS[0] + " INT " + " NOT NULL " + " AUTO_INCREMENT " + ","+
					" PRIMARY KEY ("+FIELDS[0]+") , CONSTRAINT "
					+FOREIGN+" FOREIGN KEY ("+FIELDS[0]+") "+
					"  REFERENCES arme ("+FIELDS[0]+")) ENGINE=InnoDB DEFAULT CHARSET=UTF8";		
	
	public static final String ALTER_TABLE_FK = "ALTER TABLE "+TABLE+ 
			" ADD CONSTRAINT "+FOREIGN+ 
			" FOREIGN KEY "+FIELDS[0]+ 
			" REFERENCES arme "+FIELDS[0];
	
	public static final String DROP_TABLE = "DROP TABLE IF EXISTS "+TABLE+";";
	
	public static final String INSERT_CONST = "INSERT INTO "
					+TABLE+" ("+FIELDS[0]+")"
					+ " VALUES "+" (?)";

	public static final String INNER_JOIN_ARME = " INNER JOIN arme ON arme."+FIELDS[0]+" = "+TABLE+"."+FIELDS[0]+"";
	

	@Override
	public String getTable() {
		return TABLE;
	}
	@Override
	public String[] getFields() {
		// TODO Auto-generated method stub
		return FIELDS;
	}
	@Override
	public String getSelectTable() {
		// TODO Auto-generated method stub
		return SELECT_FIELDS;
	}
	@Override
	public String getCreateTable() {
		// TODO Auto-generated method stub
		return CREATE_TABLE;
	}
	@Override
	public String getDropTable() {
		// TODO Auto-generated method stub
		return DROP_TABLE;
	}
	@Override
	public String getContForeign() {
		// TODO Auto-generated method stub
		return ALTER_TABLE_FK;
	}
	@Override
	public String getInnerJoin() {
		// TODO Auto-generated method stub
		return INNER_JOIN_ARME;
	}
}
