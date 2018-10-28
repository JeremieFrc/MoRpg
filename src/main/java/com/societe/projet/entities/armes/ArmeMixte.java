package com.societe.projet.entities.armes;

import com.societe.projet.entities.armures.Armure;

public class ArmeMixte extends Arme {
	//************************************************//
	//	 @Constructeur 
	//***********************************************//
	
	private ArmePhysique armePhysique; 
	private ArmeMagique armeMagique;
	
	//pas de point degat defint dufait que ce sont des arme ayant leurr propre point degat action
	
	public ArmeMixte(ArmePhysique armePhysique, ArmeMagique armeMagique) {
		
		this.armePhysique = armePhysique;
		this.armeMagique = armeMagique;
	}
	//************************************************//
	//	 @Setter and @getter
	//***********************************************//
	
	public ArmePhysique getArmePhysique() {
		return armePhysique;
	}

	public void setArmePhysique(ArmePhysique armePhysique) {
		this.armePhysique = armePhysique;
	}

	public ArmeMagique getArmeMagique() {
		return armeMagique;
	}

	public void setArmeMagique(ArmeMagique armeMagique) {
		this.armeMagique = armeMagique;
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
