package com.societe.projet.entities.personnages;

import java.util.ArrayList;
import java.util.List;

import com.societe.projet.entities.armes.Arme;
import com.societe.projet.entities.armures.Armure;


public abstract class Personnage {
	
	private int pointVie;
	private int pointAction;
	private List <Armure> listArmure = new ArrayList<Armure>();
	private List <Arme> listArme= new ArrayList<Arme>();
	
	public Personnage (int pointVie, int pointAction) {
		
	}
	
	
	public int getPointVie() {
		return pointVie;
	}

	public int getPointAction() {
		return pointAction;
	}	
	
	public List<Armure> getListArmure() {
		return listArmure;
	}
	
	public List<Arme> getListArme() {
		return listArme;
	}
	
	
}
