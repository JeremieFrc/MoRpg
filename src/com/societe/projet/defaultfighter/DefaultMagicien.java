package com.societe.projet.defaultfighter;

import com.societe.projet.entities.armes.Arme;
import com.societe.projet.entities.armures.Armure;
import com.societe.projet.entities.personnages.Personnage;
import com.societe.projet.rpg.Magiciens;

public class DefaultMagicien extends DefaultFighter implements Magiciens{

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

	@Override
	public boolean isEquipable(Arme arme) {
		// TODO Auto-generated method stub
		return super.isEquipable(arme);
	}

	@Override
	public boolean isEquipable(Armure armure) {
		// TODO Auto-generated method stub
		return super.isEquipable(armure);
	}

}
