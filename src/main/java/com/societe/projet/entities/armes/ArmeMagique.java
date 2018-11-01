package com.societe.projet.entities.armes;

import java.util.ArrayList;
import java.util.List;

import com.societe.projet.entities.armures.Armure;

public class ArmeMagique extends Arme{
	//************************************************//
	//	 @private
	//***********************************************//	
	private List <ArmeMixte> listArmMagique = new ArrayList<ArmeMixte>();
	//************************************************//
	//	 @Constructeur 
	//***********************************************//	
	
	public ArmeMagique() {}
	
	public ArmeMagique(String nom,int degat,int cpa) {
		super(nom,degat,cpa);
	}
	
	//************************************************//
	//	 @Setter and @getter
	//***********************************************//
	public List<ArmeMixte> getLisArmtMagique() {
		return listArmMagique;
	}

	public void setListArmMagique(List<ArmeMixte> listArmMagique) {
		this.listArmMagique = listArmMagique;
	}
	//************************************************//
	//	 @Methods 
   //***********************************************//
	@Override
	public int attack(Armure armure) {
		return super.attack(armure);
	}
	
	
	
}
