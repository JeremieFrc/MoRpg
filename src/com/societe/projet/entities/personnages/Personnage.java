package com.societe.projet.entities.personnages;

import java.util.ArrayList;
import java.util.List;

import com.societe.projet.entities.armes.Arme;
import com.societe.projet.entities.armures.Armure;


public abstract class Personnage {
	private List <Armure> listArmure = new ArrayList<Armure>();
	private List <Arme> listArme= new ArrayList<Arme>();
}
