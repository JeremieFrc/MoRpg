package com.societe.projet.entities.armures;

import java.util.ArrayList;
import java.util.List;

import com.societe.projet.entities.armes.Arme;

public class ArmureMagique extends Armure {
	/*
	*************************************************
	*    @Private
	*************************************************
	 */
	
	private List <ArmureMixte> listAmurMagic = new ArrayList<ArmureMixte>();
	
	/*
	*************************************************
	*    @Constructor
	*************************************************
	 */
	
	public ArmureMagique() {}
	
	public ArmureMagique(int defence) {
		super(defence);
	}
	
	/*
	*************************************************
	*    @getter setter
	*************************************************
	 */
	
	public List<ArmureMixte> getListAmurMagic() {
		return listAmurMagic;
	}
	public void setListAmurMagic(List<ArmureMixte> listAmurMagic) {
		this.listAmurMagic = listAmurMagic;
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
