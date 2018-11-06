package com.societe.projet.entities.personnages;


import com.societe.projet.gameplay.Realisable;

public class Hero extends Personnage implements Realisable {
	

	/*
	*************************************************
	*    @Constructor
	*************************************************
	 */
	
	public Hero() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	/*
	*************************************************
	*    @Override
	*************************************************
	 */
	
	@Override
	public void actionAttaque(int frag) {
		System.out.println("----- bonus attaquant ------");
		
		//bonus point attaque bonus action
		this.setPointAttaque(this.getPointAttaque() + (frag/4));
		this.setPointAction(this.getPointAction() - (frag/2));	
	}

	@Override
	public void actionDefence(int frag) {
		// TODO Auto-generated method stub
		System.out.println("----- degat sur armure ------");
		//diminution armure
		this.getArmure().setDefence(this.getArmure().getDefence()- (frag/2));
	}

}
