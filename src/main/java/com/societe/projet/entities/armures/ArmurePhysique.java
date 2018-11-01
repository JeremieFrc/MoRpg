package com.societe.projet.entities.armures;

import java.util.ArrayList;
import java.util.List;

import com.societe.projet.entities.armes.Arme;

public class ArmurePhysique extends Armure {
	//************************************************//
	//	 @private
	//***********************************************//

	private List <ArmureMixte> listAmurPhysique = new ArrayList<ArmureMixte>();
	
	//************************************************//
	//	 @Constructeur 
	//***********************************************//
	
	public ArmurePhysique(int defence) {
		super(defence);
	}
	
	//************************************************//
	//	 @Setter and @getter
	//***********************************************//
	public List<ArmureMixte> getlistAmurPhysique() {
		return listAmurPhysique;
	}

	public void setlistAmurPhysique(List<ArmureMixte> listAmurPhysique) {
		this.listAmurPhysique = listAmurPhysique;
	}
	//************************************************//
	//	 @Methods 
	//***********************************************//
	
	public int SubitAttack(Arme arme) {
		return 0;
	}

	
}
