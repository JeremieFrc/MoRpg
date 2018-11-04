package com.societe.projet.databases.contracts.armes;

import com.societe.projet.databases.contracts.Contract;

public class ArmeContract implements Contract {
	
	/*
	*************************************************
	*    @DESCRIPTION ELEMENT TABLE
	*************************************************
	*/	
	

	public static final String TABLE = "arme";
	public static final String[] FIELDS = {"id","nom","degat","cpa"};
	public static final String SELECT_FIELDS = FIELDS[0] 
			+ "," + FIELDS[1] 
			+ "," + FIELDS[2]
			+ "," + FIELDS[3];

	/*
	*************************************************
	*    @Creation and Drop
	*************************************************
	*/	

	public static final String CREATE_TABLE =
			"CREATE TABLE " + TABLE + "(" +FIELDS[0] + " INT " + " NOT NULL " + " PRIMARY KEY AUTO_INCREMENT " + ","+
					FIELDS[1] + " VARCHAR(255) " + "," +
					FIELDS[2] + " INT  " + "," +
					FIELDS[3] + " INT  " +
			") ENGINE=InnoDB DEFAULT CHARSET=UTF8 ";
	
	public static final String DROP_TABLE = "DROP TABLE IF EXISTS "+TABLE+";";
	
	/*
	*************************************************
	*    @insert base Data
	*************************************************
	*/	
	
	public static final String INSERT_TABLE = "INSERT INTO "
			+TABLE+" ("+FIELDS[1]+","+FIELDS[2]+","+FIELDS[3]+")"
			+ " VALUES "+"('epee',12,200),"
						+"('bagette',20,20),"
						+"('hache',32,198),"
						+"('potion',12,2),"
						+"('sortillege',25,2),"
						+"('gatlin',15,2)";
	
	public static final String INSERT_TABLE_V2  = "INSERT INTO "
			+TABLE+" ("+FIELDS[1]+","+FIELDS[2]+","+FIELDS[3]+")"
			+ " VALUES "+" (?,?,?)";
	
	/*
	*************************************************
	*    @SELECT base Data Constants
	*************************************************
	*/	
	
	public static final String SELECT = "SELECT ";
	public static final String FROM = " FROM ";
	public static final String WHERE = " WHERE ";
	public static final String PARAM = "=?";
	
	
	public static final String SELECT_ALL = SELECT + SELECT_FIELDS 
											+ FROM + TABLE;
	
	public static final String SELECT_FIRST_PREPA = SELECT + FIELDS[1]
												   + FROM + TABLE
												   + WHERE+FIELDS[1]+PARAM;
	/*
	*************************************************
	*    @OVERRIDE table
	*************************************************
	*/	
	
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
		return SELECT_FIELDS ;
	}	
	
	/*
	*************************************************
	*    @OVERRIDE query 
	*************************************************
	*/	
  
	@Override
	public String getCreateTable() {
		return CREATE_TABLE;
	}

	@Override
	public String getDropTable() {
		return DROP_TABLE;
	}

	@Override
	public String getContForeign() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getInnerJoin() {
		// TODO Auto-generated method stub
		return null;
	}
}
