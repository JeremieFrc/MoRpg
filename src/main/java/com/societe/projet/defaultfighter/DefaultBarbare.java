package com.societe.projet.defaultfighter;

import com.societe.projet.donjons.Donjon;
import com.societe.projet.entities.armes.Arme;
import com.societe.projet.entities.armes.ArmePhysique;
import com.societe.projet.entities.armures.Armure;
import com.societe.projet.entities.armures.ArmurePhysique;
import com.societe.projet.entities.personnages.Personnage;
import com.societe.projet.rpg.Barbare;
import com.societe.projet.rpg.Rpg;

public class DefaultBarbare extends DefaultFighter implements Barbare {

	

	@Override
	public String getWeasponRestriction() {
		// TODO Auto-generated method stub
		return super.getWeasponRestriction();
	}

	@Override
	public String getArmorRestriction() {
		// TODO Auto-generated method stub
		return super.getArmorRestriction();
	}

	@Override
	public void figth(Personnage defender) {
		// TODO Auto-generated method stub
		super.figth(defender);
	}

	
	//******************************************************//
	//	 @ verification contraintes barbare armure et arme
	//*****************************************************//
	
	@Override
	public boolean isEquipable(Arme arme) {
		boolean result = false;
		//gestion erreur sur les type arme que select par user
		if (arme instanceof ArmePhysique) {
			result = true;
		}
		return result;
	}

	@Override
	public boolean isEquipable(Armure armure) {
		boolean result = false;
		//gestion erreur sur les type armure que select par user
		//verification instance select
		if (armure instanceof ArmurePhysique) {
			result = true;
		}
		return result;
	}

}
