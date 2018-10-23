package com.societe.projet.entities.armes;

import java.util.ArrayList;
import java.util.List;

public class ArmeMagique extends Arme{
	public ArmeMagique(int degat, int cPA) {
		super(degat, cPA);
	}

	private List <ArmeMixte> listPhysique = new ArrayList<ArmeMixte>();
}
