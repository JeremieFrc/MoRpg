package main.java.com.societe.projet.entities.armes;

import java.util.ArrayList;
import java.util.List;

import main.java.com.societe.projet.entities.armures.ArmureMixte;

public class ArmePhysique extends Arme {
	//************************************************//
	//	 @private
	//***********************************************//	
	private List <ArmeMixte> listPhysique = new ArrayList<ArmeMixte>();
	//************************************************//
	//	 @Constructeur 
	//***********************************************//	
	public ArmePhysique(int degatMagit, int degatPhysique, int cpa) {
		super(degatMagit, degatPhysique, cpa);
		// TODO Auto-generated constructor stub
	}

	
}
