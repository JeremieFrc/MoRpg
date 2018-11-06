package com.societe.projet.entities.personnages;


import com.societe.projet.entities.armures.Armure;
import com.societe.projet.gameplay.Realisable;

public class Monstre extends Personnage implements Realisable{
	
	
	/*
	*************************************************
	*    @Constructor
	*************************************************
	 */
	
	
	 public Monstre() {
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
		System.out.println("*****************");
		System.out.println("----- bonus  ------");
		//diminution armure
		this.setPointAttaque(this.getPointAction() + (frag/2));
		
	}

	@Override
	public void actionDefence(int frag) {
		// TODO Auto-generated method stub
				System.out.println("----- degat sur armure ------");
				//diminution armure
				this.getArmure().setDefence(this.getArmure().getDefence()- (frag/2));
	}
	 
	
	
		

}
