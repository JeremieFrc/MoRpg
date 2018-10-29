package com.societe.projet;

import com.societe.projet.defaultfighter.DefaultBarbare;
import com.societe.projet.donjons.Donjon;
import com.societe.projet.entities.personnages.Personnage;

public class ApplicationCombat {

	public static void main(String[] args) {
	
		
	//************************************************//
	//	 @init objets
	//***********************************************//
		
		//********************//
		//	 @Heros
		//*******************//
		//********************//
		//	 @Monstres
		//*******************//
		System.out.println("test");
		
		Donjon persGeneric = new Donjon();
		//init personnage nom
		persGeneric.setNom("barbare");
		//init les elements de vies
		//pers = donjon appel setdefaultt recupheros renvoi donjon et use method attr revoi person
		Personnage barbare = persGeneric.setDefaultHero(new DefaultBarbare()).attributLife();
		
		barbare.affichePersonnage();
		
		//init les element de armes et armure
		
		
		
		
		
		
	}

}
