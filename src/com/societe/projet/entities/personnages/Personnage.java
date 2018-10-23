package com.societe.projet.entities.personnages;

import java.util.ArrayList;
import java.util.List;

import com.societe.projet.entities.armes.Arme;
import com.societe.projet.entities.armures.Armure;


public abstract class Personnage {
	//************************************************//
	//	 @private
	//***********************************************//	
	
	private List <Armure> listArmure = new ArrayList<Armure>();
	private List <Arme> listArme= new ArrayList<Arme>();
	
	private int pointVie;
	private int pointAction;
	
	//************************************************//
	//	 @Constructeur 
	//***********************************************//	
	
	/**
	 * 
	 * @param pointVie
	 * @param pointAction
	 */

	public Personnage(int pointVie,int pointAction) {
		this.pointVie = pointVie;
		this.pointAction = pointAction;
	}

	//************************************************//
	//	 @Setter and @getter
	//***********************************************//	
	public int getPointVie() {
		return pointVie;
	}


	public void setPointVie(int pointVie) {
		this.pointVie = pointVie;
	}


	public int getPointAction() {
		return pointAction;
	}


	public void setPointAction(int pointAction) {
		this.pointAction = pointAction;
	}
	
	
	
}
