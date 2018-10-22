package com.societe.projet.rpg;

import java.util.ArrayList;
import java.util.List;

import com.societe.projet.defaultfighter.DefaultFighter;
import com.societe.projet.entities.armes.Arme;
import com.societe.projet.entities.armures.Armure;
import com.societe.projet.entities.personnages.Personnage;

public abstract class Rpg implements DefaultFighter {
	
	private List<Personnage> listPersonnage = new ArrayList<Personnage>();	
	
	
	
	abstract String getWeasponRestriction();
	abstract String getArmorRestriction();
	
	abstract void figth(Personnage defender);
	abstract boolean isEquipable(Arme arme);
	abstract boolean isEquipable(Armure armure);
	
	
}
