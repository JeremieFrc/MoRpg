package com.societe.projet.databases.contracts.armures;

import com.societe.projet.databases.contracts.Contract;

public class ArmureContract implements Contract {
	
	/********* DESCRIPTION ELEMENT TABLE **************/

	public static final String TABLE = "Armure";
	public static final String[] FIELDS = {"id","nom","defence"};	
	public static final String SELECT_FIELDS = FIELDS[0] 
			+ "," + FIELDS[1] 
			+ "," + FIELDS[2];
	
	/********* Creation and Drop **************/
	
	public static final String CREATE_TABLE =
			"CREATE TABLE " + TABLE + "(" +FIELDS[0] + " INT " + " NOT NULL " + " PRIMARY KEY AUTO_INCREMENT " + ","+
					FIELDS[1] + " VARCHAR(255) " + "," +
					FIELDS[2] + " INT " +
			") ENGINE=InnoDB DEFAULT CHARSET=UTF8 ";
	
	public static final String DROP_TABLE = "DROP TABLE IF EXISTS "+TABLE+";";
	
	/************* INSERT *************/
	
	public static final String INSERT_TABLE = "INSERT INTO "
	+TABLE+" ("+FIELDS[1]+","+FIELDS[2]+")"
			+ " VALUES "+"('bouclier',15),"
						+"('fronte',200),"
						+"('cape',15),"
						+"('animal',12),"
						+"('voiture',20),"
						+"('sable',2)";
	
	public static final String INSERT_TABLE_V2  = "INSERT INTO "
	+TABLE+" ("+FIELDS[1]+","+FIELDS[2]+")"
			+ " VALUES "+" (?,?)";
	
	
		
	/************* SELECT *************/
	
	public static final String SELECT = "SELECT ";
	public static final String FROM = " FROM ";
	public static final String WHERE = " WHERE ";
	public static final String PARAM = "=?";
		
	public static final String SELECT_ALL = SELECT + SELECT_FIELDS 
											+ FROM + TABLE;
	
	public static final String SELECT_FIRST_PREPA = SELECT + FIELDS[1]
												   + FROM + TABLE
												   + WHERE+FIELDS[1]+PARAM;

	/********* OVERRIDE **************/
	
	@Override
	public String getTable() {
		return TABLE;
	}
	@Override
	public String[] getFields() {
		return FIELDS;
	}
	@Override
	public String getSelectTable() {
		// TODO Auto-generated method stub
		return SELECT_FIELDS ;
	}
   
	/************** requete bdd ********************/
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
		return null;
	}

}
