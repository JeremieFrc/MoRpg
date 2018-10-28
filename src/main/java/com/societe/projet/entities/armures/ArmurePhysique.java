package com.societe.projet.entities.armures;

import java.util.ArrayList;
import java.util.List;

import com.societe.projet.entities.armes.Arme;

public class ArmurePhysique extends Armure {
	//************************************************//
	//	 @private
	//***********************************************//

	private List <ArmureMixte> listAmurPhysiqye = new ArrayList<ArmureMixte>();
	
	//************************************************//
	//	 @Constructeur 
	//***********************************************//
	
	public ArmurePhysique(int defencePhysique, int defenceMagic) {
		super(defencePhysique, defenceMagic);
	}
	
	//************************************************//
	//	 @Setter and @getter
	//***********************************************//
	public List<ArmureMixte> getListAmurPhysiqye() {
		return listAmurPhysiqye;
	}

	public void setListAmurPhysiqye(List<ArmureMixte> listPhysiqye) {
		this.listAmurPhysiqye = listPhysiqye;
	}
	//************************************************//
	//	 @Methods 
	//***********************************************//
	
	public int SubitAttack(Arme arme) {
		return 0;
	}

	
}
