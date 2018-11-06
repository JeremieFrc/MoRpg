package com.societe.projet.defaultfighter;


import com.societe.projet.entities.armes.Arme;
import com.societe.projet.entities.armures.Armure;
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
		// TODO Auto-generated method stub
		
		System.out.println("--------fitght defaultFighter------");
		
		if (this.getPersonnage().getPointVie() > 0 && (this.verifiedTyp(this.getPersonnage()) == this.verifiedTyp(defender))) {
			
			int frag = this.getPersonnage().getArme().attack(defender.getArmure())
					+ this.getPersonnage().getArme().getDegat();
		
			System.out.println(frag);
		}else {
			 System.out.println("Aucun impact");
		}
		System.out.println("this "+this.verifiedTyp(this.getPersonnage()));
		System.out.println("defender "+this.verifiedTyp(defender));
		
		//this.getPersonnage().affichePersonnage();
		

	}
	public <T> int verifiedTyp(T perso) {
		int response = 0 ; 
		if( ((Personnage) perso).getRpg() instanceof Paladin ) {
			System.out.print(" Paladin");
			response = 1;
		 }else if( ((Personnage) perso).getRpg() instanceof Barbare ) {
			 System.out.print(" barbare");
			 response = 2;
		 }else if( ((Personnage) perso).getRpg() instanceof Magiciens ) {
			 response = 3;
			 System.out.print(" Magiciens");
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
