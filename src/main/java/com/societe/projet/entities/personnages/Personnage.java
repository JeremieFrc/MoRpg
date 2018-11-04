package com.societe.projet.entities.personnages;


import java.util.List;

import com.societe.projet.entities.armes.Arme;
import com.societe.projet.entities.armures.Armure;
import com.societe.projet.gameplay.Butin;
import com.societe.projet.rpg.Rpg;


public abstract class Personnage {
	
	/*
	*************************************************
	*    @Private
	*************************************************
	 */
	
	private String name;
	
	private int pointVie;
	private int pointAction;
	private int pointAttaque;
	
	private Arme arme;
	private Armure armure;
	
	private  Rpg rpg;
	
	private List<Butin> butins;
	
	/*
	*************************************************
	*    @Constructor
	*************************************************
	 */
	
	/**
	 * 
	 * @param pointVie
	 * @param pointAction
	 * @param pointAttaque
	 * @param name
	 */
	
	public Personnage() {}
	
	public Personnage(String name,int pointVie,int pointAction,int pointAttaque) {
		this.name = name;
		this.pointVie = pointVie;
		this.pointAction = pointAction;
		this.pointAttaque = pointAction;
	}
	
	/*
	*************************************************
	*    @getter setter
	*************************************************
	 */
	
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
	
	/*
	*************************************************
	*    @getter setter
	*************************************************
	 */
	
	public Arme getArme() {
		return arme;
	}

	public void setArme(Arme arme) {
		this.arme = arme;
	}

	public Armure getArmure() {
		return armure;
	}
	public void setArmure(Armure armure) {
		this.armure = armure;
	}
	
	/*
	*************************************************
	*    @getter setter butin
	*************************************************
	 */
	
	public List<Butin> getButins() {
		return butins;
	}
	public void setButins(List<Butin> butins) {
		this.butins = butins;
	}

	/*
	*************************************************
	*    @getter setter rpg
	*************************************************
	 */
	
	public Rpg getRpg() {
		return rpg;
	}

	public void setRpg(Rpg rpg) {
		this.rpg = rpg;
	}
	
	/*
	*************************************************
	*    @Methods
	*************************************************
	 */
	
	public void affichePersonnage() {
		System.out.println("------Personnage------------");
		System.out.println("nom : "+name);
		System.out.println("point de vie : "+pointVie);
		System.out.println("point action : "+pointAction);
		System.out.println("point attaque : "+pointAction);
	}
}
