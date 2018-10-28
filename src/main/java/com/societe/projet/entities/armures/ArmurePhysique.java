package com.societe.projet.entities.armures;

import java.util.ArrayList;
import java.util.List;

import com.societe.projet.entities.armes.Arme;

public class ArmurePhysique extends Armure {
	//************************************************//
	//	 @private
	//***********************************************//

	private List <ArmureMixte> listPhysiqye = new ArrayList<ArmureMixte>();
	
	//************************************************//
	//	 @Constructeur 
	//***********************************************//
	
	public ArmurePhysique(int defencePhysique, int defenceMagic) {
		super(defencePhysique, defenceMagic);
	}
	
	//************************************************//
	//	 @Setter and @getter
	//***********************************************//
	public List<ArmureMixte> getListPhysiqye() {
		return listPhysiqye;
	}

	public void setListPhysiqye(List<ArmureMixte> listPhysiqye) {
		this.listPhysiqye = listPhysiqye;
	}
	//************************************************//
	//	 @Methods 
	//***********************************************//
	
	public int SubitAttack(Arme arme) {
		return 0;
	}

	
}
