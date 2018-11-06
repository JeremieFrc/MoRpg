package com.societe.projet.defaultfighter;

import com.societe.projet.entities.armes.Arme;
import com.societe.projet.entities.armes.ArmeMagique;
import com.societe.projet.entities.armures.Armure;
import com.societe.projet.entities.armures.ArmureMagique;
import com.societe.projet.entities.personnages.Personnage;
import com.societe.projet.rpg.Magiciens;

public class DefaultMagicien extends DefaultFighter implements Magiciens{
	
	
	
	/*
	*************************************************
	*    @Constructor
	*************************************************
	 */
	public DefaultMagicien() {
		
	}
	
	
	public DefaultMagicien(Personnage personne) {
		// TODO Auto-generated constructor stub
		super(personne);
	}
	
	
	/*
	*************************************************
	*    @Override
	*************************************************
	 */
	
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
		//System.out.println("--------fitght defaultMagiciens------");
		super.figth(defender); //redirection defaultFighter
	}
	
	/*
	*********************************************************
	*    @@verification contraintes barbare armure  arme
	*******************************************************
	 */
	
	@Override
	public boolean isEquipable(Arme arme) {
		boolean result = false;
		if (arme instanceof ArmeMagique) {
			result = true;
		}
		return result;
	}

	@Override
	public boolean isEquipable(Armure armure) {
		boolean result = false;
		if (armure instanceof ArmureMagique) {
			result = true;
		}
		return result;
	}

}
