package com.societe.projet.entities.armes;

import java.util.ArrayList;
import java.util.List;

import com.societe.projet.entities.armures.Armure;


public class ArmePhysique extends Arme {
	/*
	*************************************************
	*    @Private
	*************************************************
	 */
	private List<ArmeMixte> listArmPhysique = new ArrayList<ArmeMixte>();
	
	/*
	*************************************************
	*    @Constructor
	*************************************************
	 */
	
	public ArmePhysique() {}

	public ArmePhysique(String nom,int degat,int cpa) {
		super(nom,degat,cpa);
	}
	
	/*
	*************************************************
	*    @getter setter
	*************************************************
	 */
	
	public List<ArmeMixte> getListArmPhysique() {
		return listArmPhysique;
	}

	public void setListArmPhysique(List<ArmeMixte> listArmPhysique) {
		this.listArmPhysique = listArmPhysique;
	}

	/*
	*************************************************
	*    @Override
	*************************************************
	 */
	
	@Override
	public int attack(Armure armure) {
		// TODO Auto-generated method stub
		return super.attack(armure);
	}
}
