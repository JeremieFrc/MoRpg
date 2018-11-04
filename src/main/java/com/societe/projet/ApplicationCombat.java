package com.societe.projet;


import java.util.ArrayList;
import java.util.List;

import com.societe.projet.databases.DBOUtilitaire;
import com.societe.projet.databases.contracts.armes.ArmeContract;
import com.societe.projet.databases.contracts.armes.ArmeMagiqueContract;
import com.societe.projet.databases.contracts.armes.ArmePhysiqueContract;
import com.societe.projet.databases.contracts.armures.ArmureContract;
import com.societe.projet.databases.contracts.armures.ArmureMagiqueContract;
import com.societe.projet.databases.contracts.armures.ArmurePhysicContract;
import com.societe.projet.databases.dao.DAOManager;
import com.societe.projet.databases.dto.ArmeMagiqueDTO;
import com.societe.projet.databases.dto.ArmePhysiqueDTO;
import com.societe.projet.databases.dto.ArmureMagiqueDTO;
import com.societe.projet.databases.dto.ArmurePhysiqueDTO;
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
		Donjon persGeneric = new Donjon(scanners);   //def : ok
		//persGeneric.initMenu();						//def : ok
		//persGeneric.interfaceGame();				//def : ok	
		
	 
	 //************************************************//
	//	 @Testt unitaie init Object
	//***********************************************//
	 
	 //testInitObject(persGeneric); //ok
	 //testSelectV1(); //ok
		
		
		//declararer  1 heros et un monstre
		//les faire ce battre method attak
		//programmer attack fonction des caract des personnage
	 
	/*
	*************************************************
	*     @Close Connection Bdd and scanner
	*************************************************
	*/
	 scanners.closeScanner(); 	//def : ok
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
		
	
	
	
	//************************************************//
	//	 @Testt unitai init Object
	//***********************************************//
	
	
	
	
	
	
	public static void testInitArmu() {
		DAOManager<Armure> armuDAOManager = new DAOManager<>();
		DAOManager<ArmureMagique> armugDAOManager = new DAOManager<>();
		DAOManager<ArmurePhysique> armupDAOManager = new DAOManager<>();
		
		armuDAOManager.createTable(ArmureContract.CREATE_TABLE);
		armugDAOManager.createTable(ArmureMagiqueContract.CREATE_TABLE_V2);
		armupDAOManager.createTable(ArmurePhysicContract.CREATE_TABLE_V2);	
		
		armuDAOManager.insertBdd(ArmureContract.INSERT_TABLE);
		//armuDAOManager.initConstraintPrepaStat(ArmureMagiqueContract.INSERT_CONST,ArmurePhysicContract.INSERT_CONST);
		armugDAOManager.initConstraintPrepaStat(ArmureMagiqueContract.INSERT_CONST,1,4);
		armupDAOManager.initConstraintPrepaStat(ArmurePhysicContract.INSERT_CONST,4,7);
	}
	
	public static void testSelectV1() {
		
		//dao genenerique
		DAOManager<ArmeMagique> armeDAOManager = new DAOManager<>();
		DAOManager<ArmePhysique> armepDAOManager = new DAOManager<>();
		
		DAOManager<ArmureMagique> armuDAOManager = new DAOManager<>();
		DAOManager<ArmurePhysique> armupDAOManager = new DAOManager<>();
		
		ArrayList<ArmeMagique> armic = armeDAOManager.selectAllJoin(new ArmeMagiqueContract(), new ArmeMagiqueDTO());
		ArrayList<ArmePhysique> armp = armepDAOManager.selectAllJoin(new ArmePhysiqueContract(), new ArmePhysiqueDTO());
		
		ArrayList<ArmureMagique> armuc = armuDAOManager.selectAllJoin(new ArmureMagiqueContract(), new ArmureMagiqueDTO());
		ArrayList<ArmurePhysique> armup = armupDAOManager.selectAllJoin(new ArmurePhysicContract(), new ArmurePhysiqueDTO());
	
		affEquipment(armic);
		//affEquipment(armp);
		
		affEquipment(armuc);
		//affArmu(armup);	
	}
	
	
	public static <T> void affEquipment(List <T> item) {
		for (T a : item) {	
			if( a instanceof Arme) {
				((Arme) a).affiArme();
			}else if (a instanceof Armure) {
				((Armure) a).affiArmure();
			}
		}
	}

	
	public static void testInitObject( Donjon persGeneric ) {
		
		 Personnage p = new Hero();
		 p.setRpg(new DefaultPaladin());
		 
		//verification de l'instance
		 
		 if( p.getRpg() instanceof Paladin ) {
			 System.out.println("Ceci est bien une instance de type Paladin");
		 }//tres important
		 
		//************************************************//
		//	 @init object
		//***********************************************//
			//********************//
			//	 @Heros
			//*******************//
		    ;
			//Donjon persGeneric = new Donjon();
			//init personnage nom
			persGeneric.setNom("barbare");
			//init les elements de vies
			//pers = donjon appel setdefaultt recupheros renvoi donjon et use method attr revoi person
			Personnage barbare = persGeneric.setDefaultHero(new DefaultBarbare()).dftAttributLife();
			
			barbare.affichePersonnage();
			
			//************************************************//
			//	 @init arme armure  heros
			//***********************************************//
			  
			//personnage ->  barbare->rpg ->.isEquipable(arme);
			
			//declaration arme 
			
			//exmple information de la base data
			
			//barbare.getRpg().isEquipable(armMigic) 
			// barbare.getRpg().isEquipable(armuMigic)
			
			ArmeMagique armMigic = new ArmeMagique("dkdk",12,12);
			ArmureMagique armuMigic = new ArmureMagique(12);
			
			ArmePhysique armP = new ArmePhysique("buklle",12,12);
			ArmurePhysique armuP = new ArmurePhysique(12);
			
			
			if(barbare.getRpg().isEquipable(armMigic) && barbare.getRpg().isEquipable(armuMigic) ) {
				System.out.print("vrai");
				
			}else {
				System.out.println("error pas equipable");
			}
			
			//init avec arme et armure physique barbare aceed setArmeBarbare
			barbare.setArme(armP);
			barbare.setArmure(armuP);
			
			((Arme) barbare.getArme()).affiArme();
			((Armure) barbare.getArmure()).affiArmure();
			
		
			persGeneric = null;
			
			//********************//
			//	 @Monstres
			//*******************//
			
			persGeneric = new Donjon();
			persGeneric.setNom("monster1");
			Personnage monstre1 = persGeneric.setDefaultHero(new DefaultBarbare()).dftAttributLife();
			
			monstre1.affichePersonnage();

	}
}
