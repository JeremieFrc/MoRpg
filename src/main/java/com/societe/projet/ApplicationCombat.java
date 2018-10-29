package com.societe.projet;


import com.societe.projet.defaultfighter.DefaultBarbare;
import com.societe.projet.donjons.Donjon;
import com.societe.projet.entities.armes.ArmeMagique;
import com.societe.projet.entities.armures.ArmureMagique;
import com.societe.projet.entities.personnages.Personnage;
import com.societe.projet.utils.ScannerProvider;

public class ApplicationCombat {

	public static void main(String[] args) {
		
	//************************************************//
	//	 @definition Scanner
	//***********************************************//							
	 ScannerProvider scanners = ScannerProvider.getInstance();
	 //Board menu = new Board(scanners);
		
	//************************************************//
	//	 @insert base Data
	//***********************************************//
		
		
		
		
		
		
	//************************************************//
	//	 @init object
	//***********************************************//
		//********************//
		//	 @Heros
		//*******************//
			
		Donjon persGeneric = new Donjon();
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
		
		if(barbare.getRpg().isEquipable(armMigic) && barbare.getRpg().isEquipable(armuMigic) ) {
			System.out.print("vrai");
			
		}else {
			System.out.println("error");
		}
	
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
