package com.societe.projet.donjons;

import java.util.ArrayList;
import java.util.List;

import com.societe.projet.defaultfighter.DefaultPaladin;
import com.societe.projet.entities.personnages.Hero;
import com.societe.projet.entities.personnages.Monstre;
import com.societe.projet.entities.personnages.Personnage;
import com.societe.projet.menu.Menu;
import com.societe.projet.rpg.Barbare;
import com.societe.projet.rpg.Magiciens;
import com.societe.projet.rpg.Paladin;
import com.societe.projet.rpg.Rpg;
import com.societe.projet.utils.ScannerProvider;

public class Donjon { //personnage builder lui qui gere tous les personnage point enter programme
	
	//************************************************//
	//	 @Private
	//***********************************************//
	
	private ScannerProvider scanners;
	
	private Personnage personne;
	private String nom;
	
	private int nbEtages;
	private int nbJoueurGame[];
	
	private Menu menu;
	
	
	private List <Personnage> listPersonnage = new ArrayList<Personnage>();
	private List <Monstre> listMonstre = new ArrayList<Monstre>();
	private List <Hero> listHeros= new ArrayList<Hero>();
	private List <ArrayList<Monstre>> listEtagge = new ArrayList<ArrayList<Monstre>>();
	
	//************************************************//
	//	 @Constructor
	//***********************************************//
	
	public Donjon() {}
	public Donjon(ScannerProvider scanners) {
		this.scanners = scanners;
	}
	//************************************************//
	//	 @getter setter
	//***********************************************//
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getNbEtages() {
		return nbEtages;
	}
	public void setNbEtages(int nbEtages) {
		this.nbEtages = nbEtages;
	}
	public int[] getNbJoueurGame() {
		return nbJoueurGame;
	}
	public void setNbJoueurGame(int[] nbJoueurGame) {
		this.nbJoueurGame = nbJoueurGame;
	}
	//************************************************//
	//	 @default heros,montres life
	//***********************************************//
	
	public Donjon setDefaultHero(Rpg rpg){
		this.personne = new Hero();
		this.personne.setName(nom);
		this.personne.setRpg(rpg);
		return this; //retunr element qui utilise courant
	}
	public Donjon setDefaultMontre(Rpg rpg){
		this.personne = new Monstre();
		this.personne.setName(nom);
		this.personne.setRpg(rpg);
		return this; //retunr element qui utilise courant
	}
	public Personnage dftAttributLife() {
		this.personne.setPointVie(100);
		this.personne.setPointAction(12);
		this.personne.setPointAttaque(20);
		return personne;
	}
	public Personnage setDeftEquipement() {
		return this.personne;
	}
	//************************************************//
	//	 @menu and interaction user
	//***********************************************//
	
	public void initMenu() {
		this.menu = new Menu(scanners);
	}
	public void  interfaceGame() {	
		menu.screenGame();
		nbJoueurGame = menu.initNbJoueurs();
		nbEtages = menu.nbEtage();
		this.selectEquipe(menu.menuEquipe(),nbJoueurGame);
	}
	public void selectEquipe(int choix,int nbJoueurGame[]) {
		int response = 0;
		Personnage perso = null;
		
		switch(choix) {
		case 1 : 
			System.out.println("\n-----Personnage Heros--------\n ");
			perso = new Hero();
			createPersonnage(perso);
			break;
		case 2 : 
			response = menu.affCreatePerso(nbJoueurGame[1]);
			System.out.println("\n-----Personnage Monstre --------\n ");
			perso = new Monstre();
			createPersonnage(perso);
			break;
		default : 
			System.out.println("Error de selection");
			menu.menuEquipe();
			break;
		}
	}
	public void createPersonnage(Personnage perso) {
		int response = 0;
		int compteur = 1;
		
		while(compteur<=nbJoueurGame[0]) {
			response = menu.affCreatePerso(nbJoueurGame[0]);
			switch(response) {
				case 1:
					System.out.println("\n---- Paladin --------\n ");
					 perso.setRpg(new DefaultPaladin()); //init de type paladin
					 initPerson(perso);
					//creation paladin
					compteur++;
					break;
				case 2:
					//creation Magicien
					compteur++;
					break;
				case 3:
					//creation barbare
					compteur++;
					break;
				default:
					System.out.println("error de selection");
					response = menu.affCreatePerso(nbJoueurGame[0]);
					break;
			}
			System.out.println("boucle");
			perso = null;
		}
	}
	public void initPerson(Personnage personne) {
		
		System.out.println("\n---- Paladin --------\n ");
		
		verifiedType(personne);
		
		//init element personnage
		
		personne.setName("gauliat");
		personne.setPointVie(12);
		personne.setPointAction(22);
		personne.setPointAttaque(120);
		personne.affichePersonnage();
	}
	
	void verifiedType(Personnage perso) {
		 if( perso.getRpg() instanceof Paladin ) {
			 System.out.println("Ceci est bien une instance de type Paladin");
		 }else if( perso.getRpg() instanceof Barbare ) {
			 System.out.println("Ceci est bien une instance de type Barbare");
		 }else if( perso.getRpg() instanceof Magiciens ) {
			 System.out.println("Ceci est bien une instance de type Magicien");
		 }
	}
	
}
