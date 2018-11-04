package com.societe.projet.entities.armures;

import com.societe.projet.entities.armes.Arme;

public class ArmureMixte extends Armure {
	
	/*
	*************************************************
	*    @Private
	*************************************************
	 */
	private ArmureMagique armureMagique;
	private ArmurePhysique armurePhysique;
	

	/*
	*************************************************
	*    @Constructor
	*************************************************
	 */
	
	public ArmureMixte(ArmureMagique armureMagique, ArmurePhysique armurePhysique) {
		super();
		this.armureMagique = armureMagique;
		this.armurePhysique = armurePhysique;
	}
	
	/*
	*************************************************
	*    @getter setter
	*************************************************
	 */
	
	public ArmureMagique getArmureMagique() {
		return armureMagique;
	}
	public void setArmureMagique(ArmureMagique armureMagique) {
		this.armureMagique = armureMagique;
	}
	
	public ArmurePhysique getArmurePhysique() {
		return armurePhysique;
	}

	public void setArmurePhysique(ArmurePhysique armurePhysique) {
		this.armurePhysique = armurePhysique;
	}
	
	/*
	*************************************************
	*    @Methods
	*************************************************
	 */

	public int SubitAttack(Arme arme) {
		return 0;
	}
}
