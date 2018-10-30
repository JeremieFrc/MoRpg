package com.societe.projet.rpg;





import com.societe.projet.entities.armes.Arme;
import com.societe.projet.entities.armures.Armure;
import com.societe.projet.entities.personnages.Personnage;

public interface Rpg {
	//************************************************//
	//	 @private
	//***********************************************//
	// List <Personnage> listArmure = new ArrayList<Personnage>();
	
	 //void setPersonnage(Personnage personnage);
	
	 String getWeasponRestriction();
	 String getArmorRestriction();
	  
	//************************************************//
	//	 @methods interface
	//***********************************************//
	 void figth(Personnage defender);
	 
	 boolean isEquipable(Arme arme);
	 boolean isEquipable(Armure armure);
}
