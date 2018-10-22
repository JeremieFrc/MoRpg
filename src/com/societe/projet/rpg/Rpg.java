package com.societe.projet.rpg;

import com.societe.projet.defaultfighter.DefaultFighter;
import com.societe.projet.entities.Armes.Arme;
import com.societe.projet.entities.armures.Armure;
import com.societe.projet.entities.personnages.Personnage;

public abstract class Rpg implements DefaultFighter {
	
	abstract String getWeasponRestriction();
	abstract String getArmorRestriction();
	
	abstract void figth(Personnage defeender);
	abstract boolean isEquipable(Arme arme);
	abstract boolean isEquipable(Armure armure);
}
