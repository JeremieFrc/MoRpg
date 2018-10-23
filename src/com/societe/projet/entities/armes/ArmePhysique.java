package com.societe.projet.entities.armes;

import java.util.ArrayList;
import java.util.List;

import com.societe.projet.entities.armures.ArmureMixte;

public class ArmePhysique extends Arme {
	public ArmePhysique(int degat, int cPA) {
		super(degat, cPA);
	}

	private List <ArmeMixte> listPhysique = new ArrayList<ArmeMixte>();
}
