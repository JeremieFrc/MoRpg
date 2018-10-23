package com.societe.projet.entities.armes;

public abstract class Arme  {
	
	private int degat;
	private int cPA; // CPA = Consommation de Point d'Action
	
	public Arme (int Degat, int PA) {
	
	}
	
	public int getDegat() {
		return degat;
	}
	public int getPA() {
		return PA;
	}
	
	

}
