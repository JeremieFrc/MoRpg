package com.societe.projet.entities.armes;

import java.util.ArrayList;
import java.util.List;

import com.societe.projet.entities.armures.Armure;


public class ArmePhysique extends Arme {
	//************************************************//
	//	 @private
	//***********************************************//	
	
	private List<ArmeMixte> listArmPhysique = new ArrayList<ArmeMixte>();
	
	//************************************************//
	//	 @Constructeur 
	//***********************************************//	
	
	public ArmePhysique() {}

	public ArmePhysique(String nom,int degat,int cpa) {
		super(nom,degat,cpa);
	}
	
	//************************************************//
	//	 @Setter and @getter
	//***********************************************//
	
	public List<ArmeMixte> getListArmPhysique() {
		return listArmPhysique;
	}

	public void setListArmPhysique(List<ArmeMixte> listArmPhysique) {
		this.listArmPhysique = listArmPhysique;
	}

	//************************************************//
	//	 @Methods 
   //***********************************************//
	@Override
	public int attack(Armure armure) {
		// TODO Auto-generated method stub
		return super.attack(armure);
	}
}
