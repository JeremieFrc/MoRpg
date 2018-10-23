package com.societe.projet.entities.armes;

public abstract class Arme  {
	
	private int degat;
	private int CPA; // CPA = Consommation de Point d'Action
	
	public Arme(int degat, int cPA) {
		super();
		this.degat = degat;
		CPA = cPA;
	}
	
	public int getDegat() {
		return degat;
	}
	public int getCPA() {
		return CPA;
	}

	
	
	

}
