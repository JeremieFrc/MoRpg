package com.societe.projet.entities.armes;

import java.util.ArrayList;
import java.util.List;

import com.societe.projet.entities.armures.ArmureMixte;

public class ArmePhysique extends Arme {
	
	private List <ArmeMixte> listPhysique = new ArrayList<ArmeMixte>();
	
	public ArmePhysique(int degatMagit, int degatPhysique, int cpa) {
		super(degatMagit, degatPhysique, cpa);
		// TODO Auto-generated constructor stub
	}

	
}
