package com.societe.projet.defaultfighter;


import com.societe.projet.entities.armes.Arme;
import com.societe.projet.entities.armures.Armure;
import com.societe.projet.entities.armures.ArmurePhysique;
import com.societe.projet.entities.personnages.Personnage;
import com.societe.projet.rpg.Barbare;
import com.societe.projet.rpg.Magiciens;
import com.societe.projet.rpg.Paladin;
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
	
		System.out.println("--------fitght defaultFighter------");
		
		if (this.getPersonnage().getPointVie() > 0 && (this.verifiedTyp(this.getPersonnage()) == this.verifiedTyp(defender)) && this.getPersonnage().getPointAttaque()>0) {
			
			this.getPersonnage().affichePersonnage();
			this.getPersonnage().getArme().affiArme();
			int frag = this.getPersonnage().getArme().attack(defender.getArmure());
			System.out.println("frag "+frag);
			//defender lose life
			defender.setPointVie(defender.getPointVie()- frag); //init  new vie
			
			//affiche result	
			System.out.println("l'attack "+this.getPersonnage().getName()+" est "+this.getPersonnage().getArme().getDegat() );
			System.out.println("defencer subit des degat de "+frag+" points");
			System.out.println("defencer possede new point vie "+defender.getPointVie());
			
			//penalite sur defence armure
			defender.actionDefence(frag); //per
			
			//bonus on heros
			this.getPersonnage().actionAttaque(frag);
			
			
			//this.getPersonnage().affichePersonnage();
			//System.out.println("getPoint attaque"+this.getPersonnage().getPointAttaque());
			//System.out.println("getPoint action"+this.getPersonnage().getPointAction());
			//defender.getArmure().affiArmure();
		}else {
			 System.out.println("Aucun impact");
		}
	}
	public <T> int verifiedTyp(T perso) {
		int response = 0 ; 
		if( ((Personnage) perso).getRpg() instanceof Paladin ) {
			//System.out.println(" Paladin");
			response = 1;
		 }else if( ((Personnage) perso).getRpg() instanceof Barbare ) {
			 //System.out.println(" barbare");
			 response = 2;
		 }else if( ((Personnage) perso).getRpg() instanceof Magiciens ) {
			 response = 3;
			 //System.out.println(" Magiciens");
		 }
		return response;
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
