package com.societe.projet;


import com.societe.projet.databases.contracts.armes.ArmeContract;
import com.societe.projet.databases.contracts.armures.ArmureContract;
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
		
	//************************************************//
	//	 @definition Scanner
	//***********************************************//							
	 ScannerProvider scanners = ScannerProvider.getInstance();
	 //Board menu = new Board(scanners);
		
	 //************************************************//
	//	 @insert menu
	//***********************************************//
	 Donjon persGeneric = new Donjon(scanners);
	 //persGeneric.
	 
	 persGeneric.initMenu();
	 persGeneric.interfaceGame();
	 
	 //************************************************//
	//	 @insert base Data
	//***********************************************//
		
	 
	 testInitBdd();
	 
	 
	}
	
	public static void testInitBdd() {
		//declaration une seul instance de bdd
				DAOManager dao = new DAOManager();
				
				dao.dropTable(ArmeContract.DROP_TABLE);
				dao.dropTable(ArmureContract.DROP_TABLE);
				
				dao.createTable(ArmeContract.CREATE_TABLE); //creation ok
				dao.createTable(ArmureContract.CREATE_TABLE);
				
				//insert en dure
				dao.insertBdd(ArmeContract.INSERT_TABLE);
				dao.insertBdd(ArmureContract.INSERT_TABLE);
				
				dao.closeConnection();
				
	}
	
	public void testInit( Donjon persGeneric ) {
		
		 
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
			
			ArmeMagique armMigic = new ArmeMagique(12,24,12);
			ArmureMagique armuMigic = new ArmureMagique(12,12);
			
			ArmePhysique armP = new ArmePhysique(12,24,12);
			ArmurePhysique armuP = new ArmurePhysique(12,12);
			
			
			if(barbare.getRpg().isEquipable(armMigic) && barbare.getRpg().isEquipable(armuMigic) ) {
				System.out.print("vrai");
				
			}else {
				System.out.println("error");
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
