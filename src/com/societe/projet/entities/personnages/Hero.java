package com.societe.projet.entities.personnages;

import java.util.List;

import com.societe.projet.entities.armes.Arme;
import com.societe.projet.entities.armures.Armure;

public class Hero extends Personnage {
	
	//************************************************//
	//	 @Constructeur 
	//***********************************************//
	
	public Hero(int pointVie, int pointAction) {
		super(pointVie, pointAction);
		// TODO Auto-generated constructor stub
	}


	public Hero(List<Armure> listArmure, List<Arme> listArme, int pointVie, int pointAction) {
		super(listArmure, listArme, pointVie, pointAction);
		// TODO Auto-generated constructor stub
	}
	
	
		
}
