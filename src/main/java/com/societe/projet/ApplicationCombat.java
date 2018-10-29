package com.societe.projet;


import com.societe.projet.defaultfighter.DefaultBarbare;
import com.societe.projet.donjons.Donjon;
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
		  
		//personnage -> rpg -> barbare.isEquipable(arme);
		
		
		
		
		
		
		
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
