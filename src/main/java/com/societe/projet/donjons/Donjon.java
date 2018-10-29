package com.societe.projet.donjons;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.societe.projet.entities.personnages.Hero;
import com.societe.projet.entities.personnages.Monstre;
import com.societe.projet.entities.personnages.Personnage;
import com.societe.projet.menu.Menu;
import com.societe.projet.rpg.Rpg;
import com.societe.projet.utils.ScannerProvider;

public class Donjon { //personnage builder lui qui gere tous les personnage point enter programme
	
	//************************************************//
	//	 @Private
	//***********************************************//
	
	private Personnage personne;
	private String nom;
	
	private ScannerProvider scanner;
	private int nbEtages;
	
	
	
	
	private List <Personnage> listPersonnage = new ArrayList<Personnage>();
	private List <Monstre> listMonstre = new ArrayList<Monstre>();
	private List <Hero> listHeros= new ArrayList<Hero>();
	private List <ArrayList<Monstre>> listEtagge = new ArrayList<ArrayList<Monstre>>();
	
	//************************************************//
	//	 @Constructor
	//***********************************************//
	
	public Donjon() {}
	public Donjon(ScannerProvider scanners) {
		this.scanner = scanners;
	}
	
	//************************************************//
	//	 @getter setter
	//***********************************************//
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	//************************************************//
	//	 @default heros,montres life
	//***********************************************//
	
	public Donjon setDefaultHero(Rpg rpg){
		this.personne = new Hero();
		this.personne.setName(nom);
		this.personne.setRpg(rpg);
		return this; //retunr element qui utilise courant
	}
	public Donjon setDefaultMontre(Rpg rpg){
		this.personne = new Monstre();
		this.personne.setName(nom);
		this.personne.setRpg(rpg);
		return this; //retunr element qui utilise courant
	}
	public Personnage dftAttributLife() {
		this.personne.setPointVie(100);
		this.personne.setPointAction(12);
		this.personne.setPointAttaque(20);
		return personne;
	}
	//************************************************//
	//	 @default heros,montres Equipement
	//***********************************************//
	
	public Personnage setDeftEquipement() {
		return this.personne;
	}
	
	public void setGamePlayUser() {
		Menu meal = new Menu(scanner);
	
			switch(meal.menuEquipe()) {
				case 1 : meal.equipHero();break;
				case 2 : break;
				default :break;
			}
	}
	
	
	
	
	
	
	
	
}
