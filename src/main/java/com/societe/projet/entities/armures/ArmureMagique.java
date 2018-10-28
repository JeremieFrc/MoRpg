package com.societe.projet.entities.armures;

import java.util.ArrayList;
import java.util.List;

import com.societe.projet.entities.armes.Arme;

public class ArmureMagique extends Armure {
	//************************************************//
	//	 @private
	//***********************************************//	
	
	private List <ArmureMixte> listMagic = new ArrayList<ArmureMixte>();
	
	//************************************************//
	//	 @Constructeur 
	//***********************************************//
	public ArmureMagique(int defencePhysique, int defenceMagic) {
		super(defencePhysique, defenceMagic);
	}
	//************************************************//
	//	 @Setter and @getter
	//***********************************************//
	
	public List<ArmureMixte> getListMagic() {
		return listMagic;
	}
	public void setListMagic(List<ArmureMixte> listMagic) {
		this.listMagic = listMagic;
	}
	
	//************************************************//
	//	 @Methods 
	//***********************************************//
	public int SubitAttack(Arme arme) {
		return 0;
	}



	
}
