package com.societe.projet.donjons;

import java.util.ArrayList;
import java.util.List;

import com.societe.projet.entities.personnages.Hero;
import com.societe.projet.entities.personnages.Monstre;

public class Donjon {
	
	private int nbEtages;
	
	private List <Monstre> listMonstre = new ArrayList<Monstre>();
	private List <Hero> listHeros= new ArrayList<Hero>();
	private List <ArrayList<Monstre>> listEtagge = new ArrayList<ArrayList<Monstre>>();
	
}
