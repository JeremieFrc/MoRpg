package com.societe.projet.defaultfighter;


import com.societe.projet.entities.armes.Arme;
import com.societe.projet.entities.armures.Armure;
import com.societe.projet.entities.personnages.Personnage;
import com.societe.projet.rpg.Rpg;

public class DefaultFighter implements Rpg{

	protected Personnage personne;
	
	public void setPersonne(Personnage personne) {
		this.personne = personne;
	}
	
	public Personnage getPersonnage() {
		return personne;
	}
	/*
	*************************************************
	*    @Constructeur
	*************************************************
	 */
	public DefaultFighter() {
		// TODO Auto-generated constructor stub
	}
	
	public DefaultFighter(Personnage personne) {
		// TODO Auto-generated constructor stub
		this.personne = personne;
	}
	
	
	
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
		
	}

	@Override
	public boolean isEquipable(Arme arme) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEquipable(Armure armure) {
		// TODO Auto-generated method stub
		return false;
	}

}
