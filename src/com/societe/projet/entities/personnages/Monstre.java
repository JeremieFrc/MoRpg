package com.societe.projet.entities.personnages;

import java.util.List;

import com.societe.projet.entities.armes.Arme;
import com.societe.projet.entities.armures.Armure;

public class Monstre extends Personnage{
	
	
	//************************************************//
	//	 @Constructeur 
	//***********************************************//
	
	
	public Monstre(int pointVie, int pointAction) {
		super(pointVie, pointAction);
		
	}

	public Monstre(List<Armure> listArmure, List<Arme> listArme, int pointVie, int pointAction) {
		super(listArmure, listArme, pointVie, pointAction);
		// TODO Auto-generated constructor stub
	}
	
	

}
