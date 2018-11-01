package com.societe.projet.entities.armures;

public abstract class Armure {

	
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
		System.out.println("-----Armure -----------");
		System.out.println("defence : "+defence);
	}
	
}
