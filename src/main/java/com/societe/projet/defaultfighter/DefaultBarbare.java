package com.societe.projet.defaultfighter;


import com.societe.projet.entities.armes.Arme;
import com.societe.projet.entities.armes.ArmePhysique;
import com.societe.projet.entities.armures.Armure;
import com.societe.projet.entities.armures.ArmurePhysique;
import com.societe.projet.entities.personnages.Personnage;
import com.societe.projet.rpg.Barbare;
import com.societe.projet.rpg.Magiciens;
import com.societe.projet.rpg.Paladin;


public class DefaultBarbare extends DefaultFighter implements Barbare {
	/*
	*************************************************
	*    @Private
	*************************************************
	 */
	private Arme armeBarbare;
	
	/*
	*************************************************
	*    @getter setter
	*************************************************
	 */
	public DefaultBarbare() {
		// TODO Auto-generated constructor stub
	}
	
	
	public DefaultBarbare(Personnage personne) {
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
		// TODO Auto-generated method stub
		
		System.out.println("--------fitght defaultBarbare------");
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

	//******************************************************//
	//	 @ setEquimepent barbare armure et arme
	//*****************************************************//
	
	@Override
	public void setArmeBarbare(Arme arme) {
		armeBarbare = arme;	
	}

}
