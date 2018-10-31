package com.societe.projet.databases.contracts.armures;

import com.societe.projet.databases.contracts.Contract;

public class ArmureMagiqueContract implements Contract {
	/********* DESCRIPTION ELEMENT TABLE **************/

	public static final String   TABLE    = "armuremagique";
	public static final String[] FIELDS   = {"id"};
	public static final String   FOREIGN  = "fk_armuremagique_armure";
	
	/********* Creation constraint and Drop **************/
	
	public static final String CREATE_TABLE =
			"CREATE TABLE " + TABLE + "(" +FIELDS[0] + " INT " + " NOT NULL "+
			") ENGINE=InnoDB DEFAULT CHARSET=UTF8 ";
	
	public static final String CREATE_TABLE_V2 = 
			"CREATE TABLE " + TABLE + "(" +FIELDS[0] + " INT " + " NOT NULL " + " AUTO_INCREMENT " + ","+
					" PRIMARY KEY ("+FIELDS[0]+") , CONSTRAINT "
					+FOREIGN+" FOREIGN KEY ("+FIELDS[0]+") "+
					"  REFERENCES armure ("+FIELDS[0]+")) ENGINE=InnoDB DEFAULT CHARSET=UTF8";
					
	
	
	public static final String ALTER_TABLE_FK = "ALTER TABLE "+TABLE+ 
			" ADD CONSTRAINT "+FOREIGN+ 
			"    FOREIGN KEY "+FIELDS[0]+ 
			"    REFERENCES armure "+FIELDS[0];
	
	public static final String DROP_TABLE = "DROP TABLE IF EXISTS "+TABLE+";";

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
		return null;
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
}
