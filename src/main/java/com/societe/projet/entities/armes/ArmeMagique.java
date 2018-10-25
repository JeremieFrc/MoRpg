package com.societe.projet.entities.armes;

import java.util.ArrayList;
import java.util.List;

public class ArmeMagique extends Arme{
	//************************************************//
	//	 @private
	//***********************************************//	
	private List <ArmeMixte> listPhysique = new ArrayList<ArmeMixte>();
	//************************************************//
	//	 @Constructeur 
	//***********************************************//	
	public ArmeMagique(int degatMagit, int degatPhysique, int cpa) {
		super(degatMagit, degatPhysique, cpa);
		// TODO Auto-generated constructor stub
	}

	
}
