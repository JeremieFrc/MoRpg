package com.societe.projet.entities.armures;

import com.societe.projet.databases.DBItem;

public abstract class Armure extends DBItem {

	
	//************************************************//
	//	 @private
	//***********************************************//
	
	private String nom;
	private int defence;
	
	//************************************************//
	//	 @Constructeur 
	//***********************************************//
	
	/**
	 * 
	 * @param defencePhysique
	 * @param defenceMagic
	 */
	
	public Armure() {}
	
	public Armure(int defence) {
		this.defence = defence;
	}
	
	//************************************************//
	//	 @Setter and @getter
	//***********************************************//

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public int getDefence() {
		return defence;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}

	public void affiArmure() {
		System.out.println("\n-----Armure -----------");
		System.out.println("nom : "+nom);
		System.out.println("defence : "+defence);
	}
	
}
