package com.societe.projet.rpg;


import com.societe.projet.entities.armes.Arme;
import com.societe.projet.entities.armures.Armure;
import com.societe.projet.entities.personnages.Personnage;

public interface Rpg {
	
	/*
	*************************************************
	*    @Methods
	*************************************************
	 */
	
	 String getWeasponRestriction();
	 String getArmorRestriction();
	  
	 void figth(Personnage defender);
	 
	 boolean isEquipable(Arme arme);
	 boolean isEquipable(Armure armure);
}
