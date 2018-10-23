package com.societe.projet.entities.personnages;

import java.util.List;

import com.societe.projet.entities.armes.Arme;
import com.societe.projet.entities.armures.Armure;
import com.societe.projet.gameplay.Realisable;

public class Monstre extends Personnage implements Realisable{
	
	
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
	
	//************************************************//
	//	 @Overides 
	//***********************************************//

	@Override
	public void actionAttaque() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionDefence() {
		// TODO Auto-generated method stub
		
	}

}
