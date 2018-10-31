package com.societe.projet.databases.contracts;

public interface Contract {
	/**
	 * 
	 * methods generique 
	 * definition nom table et recuperation des champs
	 * 
	 * method de creation et select pour la table en question
	 */
	public String getTable();
	public String getContForeign();
	public String[] getFields(); //nous allons stocker nos champs
	
	public String getSelectTable();
	
	public String getCreateTable();
	public String getDropTable();
}
