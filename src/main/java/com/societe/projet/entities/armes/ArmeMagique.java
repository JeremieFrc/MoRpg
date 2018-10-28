package com.societe.projet.entities.armes;

import java.util.ArrayList;
import java.util.List;

import com.societe.projet.entities.armures.Armure;

public class ArmeMagique extends Arme{
	//************************************************//
	//	 @private
	//***********************************************//	
	private List <ArmeMixte> listMagique = new ArrayList<ArmeMixte>();
	//************************************************//
	//	 @Constructeur 
	//***********************************************//	
	
	public ArmeMagique() {}
	
	public ArmeMagique(int degatMagic, int degatPhysique,int cpa) {
		super(degatMagic, degatPhysique,cpa);
	}
	
	//************************************************//
	//	 @Setter and @getter
	//***********************************************//
	public List<ArmeMixte> getListMagique() {
		return listMagique;
	}

	public void setListMagique(List<ArmeMixte> listMagique) {
		this.listMagique = listMagique;
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
