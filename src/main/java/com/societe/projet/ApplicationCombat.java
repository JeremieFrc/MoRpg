package com.societe.projet;


import com.societe.projet.databases.DBOUtilitaire;
import com.societe.projet.databases.contracts.armes.ArmeContract;
import com.societe.projet.databases.contracts.armes.ArmeMagiqueContract;
import com.societe.projet.databases.contracts.armes.ArmePhysiqueContract;
import com.societe.projet.databases.contracts.armures.ArmureContract;
import com.societe.projet.databases.contracts.armures.ArmureMagiqueContract;
import com.societe.projet.databases.contracts.armures.ArmurePhysicContract;
import com.societe.projet.databases.dao.DAOManager;

import com.societe.projet.defaultfighter.DefaultBarbare;
import com.societe.projet.defaultfighter.DefaultPaladin;
import com.societe.projet.donjons.Donjon;
import com.societe.projet.entities.armes.Arme;
import com.societe.projet.entities.armes.ArmeMagique;
import com.societe.projet.entities.armes.ArmePhysique;
import com.societe.projet.entities.armures.Armure;
import com.societe.projet.entities.armures.ArmureMagique;
import com.societe.projet.entities.armures.ArmurePhysique;
import com.societe.projet.entities.personnages.Hero;
import com.societe.projet.entities.personnages.Personnage;
import com.societe.projet.rpg.Paladin;
import com.societe.projet.utils.ScannerProvider;

public class ApplicationCombat {

	public static void main(String[] args) {
		
	/*
	*************************************************
	*    @definition Scanner
	*************************************************
	 */
	
		ScannerProvider scanners = ScannerProvider.getInstance();
		
	/*
	*************************************************
	*    @insert base Data
	*************************************************
	*/	
		matchBDD();  //def : ok
		
	/*
	*************************************************
	*     @insert menu
	*************************************************
	*/
		Donjon persGeneric = new Donjon(scanners);       //def : ok
		persGeneric.initMenu();						//def : ok
		persGeneric.interfaceGame();				   //def : ok
		
	 
	/*
	*************************************************
	*     @Close Connection Bdd and scanner
	*************************************************
	*/
	 scanners.closeScanner(); 	     //def : ok
	 closeConnection();    		//def : ok
	}
	
	public static void matchBDD() {
		
		DAOManager<Arme> armeDAOManager = new DAOManager<>();
		DAOManager<Armure> armureDAOManager = new DAOManager<>();
		
		DAOManager<ArmeMagique> armeMDAOManager = new DAOManager<>();
		DAOManager<ArmePhysique> armePDAOManager = new DAOManager<>();
		
		DAOManager<ArmureMagique> armuMDAOManager = new DAOManager<>();
		DAOManager<ArmurePhysique> armuPDAOManager = new DAOManager<>();
		
		
		armeMDAOManager.dropTable(ArmeMagiqueContract.DROP_TABLE);
		armePDAOManager.dropTable(ArmePhysiqueContract.DROP_TABLE);
		
		armuMDAOManager.dropTable(ArmureMagiqueContract.DROP_TABLE);
		armuPDAOManager.dropTable(ArmurePhysicContract.DROP_TABLE);
		
		armureDAOManager.dropTable(ArmureContract.DROP_TABLE);
		armeDAOManager.dropTable(ArmeContract.DROP_TABLE);
		
		/*
		 * ----------  Create Table
		 */
		
		armeDAOManager.createTable(ArmeContract.CREATE_TABLE);
		armeMDAOManager.createTable(ArmeMagiqueContract.CREATE_TABLE_V2);
		armePDAOManager.createTable(ArmePhysiqueContract.CREATE_TABLE_V2);	
		
		armureDAOManager.createTable(ArmureContract.CREATE_TABLE);
		armuMDAOManager.createTable(ArmureMagiqueContract.CREATE_TABLE_V2);
		armuPDAOManager.createTable(ArmurePhysicContract.CREATE_TABLE_V2);
		
		/*
		 * ---------- Init arme et armure in bdd
		 */
		
		armeDAOManager.insertBdd(ArmeContract.INSERT_TABLE);
		armeMDAOManager.initConstraintPrepaStat(ArmeMagiqueContract.INSERT_CONST,1,4);
		armePDAOManager.initConstraintPrepaStat(ArmePhysiqueContract.INSERT_CONST,4,7);
		
		armureDAOManager.insertBdd(ArmureContract.INSERT_TABLE);
		armuMDAOManager.initConstraintPrepaStat(ArmureMagiqueContract.INSERT_CONST,1,4);
		armuPDAOManager.initConstraintPrepaStat(ArmurePhysicContract.INSERT_CONST,4,7);
	}	
	public static void closeConnection() {
		DAOManager<Arme> armeDAOManager = new DAOManager<>();
		DAOManager<Armure> armureDAOManager = new DAOManager<>();
		
		DAOManager<ArmeMagique> armeMDAOManager = new DAOManager<>();
		DAOManager<ArmePhysique> armePDAOManager = new DAOManager<>();
		
		DAOManager<ArmureMagique> armuMDAOManager = new DAOManager<>();
		DAOManager<ArmurePhysique> armuPDAOManager = new DAOManager<>();
		
		DBOUtilitaire.closeConnection(armeDAOManager.getConnection());
		DBOUtilitaire.closeConnection(armeMDAOManager.getConnection());
		DBOUtilitaire.closeConnection(armePDAOManager.getConnection());

		DBOUtilitaire.closeConnection(armureDAOManager.getConnection());
		DBOUtilitaire.closeConnection(armuMDAOManager.getConnection());
		DBOUtilitaire.closeConnection(armuPDAOManager.getConnection());	
	}
}
