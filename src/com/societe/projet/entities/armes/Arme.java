package com.societe.projet.entities.armes;

public abstract class Arme  {

	
	private int degatPhysique;
	private int degatMagit;
	private int cpa ; //point de consommation
	
	/**
	 * 
	 * @param degatMagit
	 * @param degatPhysique
	 * @param cpa
	 */
	
	public Arme (int degatMagit, int degatPhysique,int cpa) {
		this.degatMagit = degatMagit;
		this.degatPhysique = degatPhysique;
		this.cpa = cpa;
	}
	
}
