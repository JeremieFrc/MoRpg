package com.societe.projet.entities.armures;

public abstract class Armure {

	private int defencePhysique;
	private int defenceMagic;
	
	/**
	 * 
	 * @param defencePhysique
	 * @param defenceMagic
	 */
	
	public Armure(int defencePhysique, int defenceMagic) {

		this.defencePhysique = defencePhysique;
		this.defenceMagic = defenceMagic;
	}
	
	
}
