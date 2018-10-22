package com.societe.projet.rpg;

import com.societe.projet.defaultfighter.DefaultMagicien;
import com.societe.projet.entities.armes.Arme;
import com.societe.projet.entities.armures.Armure;
import com.societe.projet.entities.personnages.Personnage;

public class Magiciens extends Rpg implements DefaultMagicien {

	@Override
	String getWeasponRestriction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	String getArmorRestriction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	void figth(Personnage defeender) {
		// TODO Auto-generated method stub
		
	}

	@Override
	boolean isEquipable(Arme arme) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	boolean isEquipable(Armure armure) {
		// TODO Auto-generated method stub
		return false;
	}

}
