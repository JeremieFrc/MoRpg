package com.societe.projet.defaultfighter;

import com.societe.projet.entities.armes.Arme;
import com.societe.projet.entities.armes.ArmeMagique;
import com.societe.projet.entities.armes.ArmeMixte;
import com.societe.projet.entities.armures.Armure;
import com.societe.projet.entities.armures.ArmureMagique;
import com.societe.projet.entities.armures.ArmureMixte;
import com.societe.projet.entities.personnages.Personnage;
import com.societe.projet.rpg.Paladin;

public class DefaultPaladin extends DefaultFighter implements Paladin {
	
	/*
	*************************************************
	*    @Override
	*************************************************
	 */
	@Override
	public String getWeasponRestriction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getArmorRestriction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void figth(Personnage defender) {
		// TODO Auto-generated method stub
		//System.out.println("--------fitght Paladin-----");
		super.figth(defender);
	}
	
	/*
	*********************************************************
	*    @@verification contraintes barbare armure  arme
	*******************************************************
	 */
	
	@Override
	public boolean isEquipable(Arme arme) {
		boolean result = false;
		
		if (arme instanceof ArmeMixte || arme instanceof ArmeMagique) {
			result = true;
		}
		return result;
	}

	@Override
	public boolean isEquipable(Armure armure) {
		boolean result = false;
		if (armure instanceof ArmureMixte || armure instanceof ArmureMagique) {
			result = true;
		}
		return result;
	}

}
