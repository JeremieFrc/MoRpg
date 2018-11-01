package com.societe.projet.entities.armes;

import com.societe.projet.databases.DBItem;
import com.societe.projet.entities.armures.Armure;

public abstract class Arme extends DBItem {
	//************************************************//
	//	 @private
	//***********************************************//
	
	private String nom;
	private int degat;
	private int cpa ; //point de consommation
	
	//************************************************//
	//	 @Constructeur 
	//***********************************************//	
	
	/**
	 * 
	 * @param degatMagic
	 * @param degatPhysique
	 * @param cpa
	 */
	public Arme() {}

	public Arme (int degat,int cpa) {
		this.degat= degat;
		this.cpa = cpa;
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
	
	public void setDegat(int degat) {
		this.degat = degat;
	}
	
	public int getDegat() {
		return degat;
	}
	
	public int getCpa() {
		return cpa;
	}

	public void setCpa(int cpa) {
		this.cpa = cpa;
	}
	
	//************************************************//
	//	 @Methods 
   //***********************************************//
	public int attack(Armure armure) {
		int result = 0;
		result = this.getDegat() - armure.getDefence();
		return result > 0 ? result : 0; //application ternaire
	}
	public void affiArme() {
		System.out.println("\n----- Arme : ----------");
		System.out.println("nom : "+nom);
		System.out.println("degat : "+degat);
		System.out.println("cpa : "+cpa);
	}
}
