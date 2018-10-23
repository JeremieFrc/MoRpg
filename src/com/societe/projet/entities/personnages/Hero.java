package com.societe.projet.entities.personnages;

import java.util.List;

import com.societe.projet.entities.armes.Arme;
import com.societe.projet.entities.armures.Armure;
import com.societe.projet.gameplay.Realisable;

public class Hero extends Personnage implements Realisable {
	
	//************************************************//
	//	 @Private
	//***********************************************//
		
		private int butin;
	
	//************************************************//
	//	 @Constructeur 
	//***********************************************//
	
	public Hero(int pointVie, int pointAction) {
		super(pointVie, pointAction);
		// TODO Auto-generated constructor stub
	}


	public Hero(List<Armure> listArmure, List<Arme> listArme, int pointVie, int pointAction,int butin ){
		super(listArmure, listArme, pointVie, pointAction);
		// TODO Auto-generated constructor stub
		this.butin = butin;
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
