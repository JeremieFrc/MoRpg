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
	
	private String name;
	private int pointVie;
	private int pointAction;
	private int pointAttaque;
	
	
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

	public Personnage(List<Armure> listArmure, List<Arme> listArme, int pointVie, int pointAction) {
		
		this.listArmure = listArmure;
		this.listArme = listArme;
		this.pointVie = pointVie;
		this.pointAction = pointAction;
	}

	//************************************************//
	//	 @Setter and @getter
	//***********************************************//	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
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
	
	public int getPointAttaque() {
		return pointAttaque;
	}

	public void setPointAttaque(int pointAttaque) {
		this.pointAttaque = pointAttaque;
	}
	
	
	//************************************************//
	//	 @Setter and @getter List
	//***********************************************//	

	

	public List<Armure> getListArmure() {
		return listArmure;
	}

	public void setListArmure(Armure armuree) {
		this.listArmure.add(armuree);
	}

	public List<Arme> getListArme() {
		return listArme;
	}

	public void setListArme(Arme arm) {
		this.listArme.add(arm);
	}
}
