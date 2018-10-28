package com.societe.projet.donjons;

import java.util.ArrayList;
import java.util.List;

import com.societe.projet.entities.personnages.Hero;
import com.societe.projet.entities.personnages.Monstre;
import com.societe.projet.entities.personnages.Personnage;

public class Donjon { //personnage builder lui qui gere tous les personnage point enter programme
	
	
	private List <Personnage> listPersonnage = new ArrayList<Personnage>();
	
	private List <Monstre> listMonstre = new ArrayList<Monstre>();
	private List <Hero> listHeros= new ArrayList<Hero>();
	
	private List <ArrayList<Monstre>> listEtagge = new ArrayList<ArrayList<Monstre>>();
	private int nbEtages;
	

}
