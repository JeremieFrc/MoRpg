package com.societe.projet.menu;

import com.societe.projet.utils.ScannerProvider;

public class Menu {
	
	/*
	*************************************************
	*    @Constante
	*************************************************
	 */
	
	public static final String SCREEN_GAME   = "\n-------- bienvenue Jeux RPG -----------\n\n";
	public static final String SCREEN_CONFIG = "Configuration Jeux : \n\n";
	
	/*
	*************************************************
	*    @Private
	*************************************************
	 */
	
	private ScannerProvider scanner;
	
	/*
	*************************************************
	*    @Constructor
	*************************************************
	 */
	
	/**
	 * @param scanner
	 */
	
	public Menu(ScannerProvider scanner) {
		this.scanner = scanner;
	}	
	
	/*
	*************************************************
	*    @Methods
	*************************************************
	 */
	
	public void screenGame() {
		System.out.println(SCREEN_GAME);
	}
	
	public int[] initNbJoueurs() {
		
		int nbJoueur[] = new int[2];
		System.out.println(SCREEN_CONFIG);
		System.out.println("\n\n\n-------- Nombres Joueurs par Equipe -------------\n");
		
		System.out.println("Nombre joueurs equipe de HEROS : ");
		System.out.print("Choix : ");
		
		nbJoueur[0] = scanner.getScanner().nextInt();
		scanner.getScanner().nextLine();
		
		System.out.println("Nombre joueurs equipe de Monstre : ");
		System.out.print("Choix : ");
		
		nbJoueur[1] = scanner.getScanner().nextInt();
		scanner.getScanner().nextLine();
		
		this.verifNbJoueur(nbJoueur);
		
		return nbJoueur;
	}
	
	public void verifNbJoueur(int tab[]) {
		
		//parcourir tab and verification data
		//boolean response = true;
		
		for(int i = 0; i<tab.length;i++) {
			if(tab[i] < 0) {
				System.out.println(" Error de saisie Joueur ");
				this.initNbJoueurs();
			}
		}
	}	
	
	public int nbEtage() {
		int nb = 0;
		
		System.out.println("\n\n\n--------Saisie nombre etage pour Donjon----------\n");
		System.out.print("Choix : ");
		
		nb = scanner.getScanner().nextInt();
		scanner.getScanner().nextLine();
		
		if(nb <= 0) {
			System.out.println("Error de saisie");
			this.nbEtage();
		}
		return nb;
	}
	
	public int menuEquipe() {
		int response = 0;
		
		System.out.println("\n-------- creation des Personnages ---------------\n");
		
		System.out.println("Equipe de HEROS  [1]");
		System.out.println("Equipe de Montre [2]");
		System.out.print("Choix : ");
		
		response = scanner.getScanner().nextInt();
		scanner.getScanner().nextLine();
		
		return response;
	}	
	
	public int affCreatePerso(int nbJoueurGame) {

		System.out.println("Equipe nbPerso maximun : "+nbJoueurGame);
		
		System.out.println("\nPersonnage Paladin   [1]");
		System.out.println("Personnage Magicien  [2]");
		System.out.println("Personnage Barbare   [3]");
		System.out.print("choix : ");
		
		return scanner.getScanner().nextInt();	
	}
	
	public void menuArme() {
		System.out.println("\nPersonnage Paladin [1]");
		System.out.println("Personnage Magicien  [2]");
		System.out.println("Personnage Barbare   [3]");	
	}
	
	public int menuMonstreEtage(int totalMontre) {
		
		System.out.println("\n\n\n-------- Choix monstre par Etages ------------");
		System.out.println("\nTotal montre dans arene : "+totalMontre);
		System.out.println("Combien Monstre par etage  ");
		System.out.print("Choix : ");
		
		int choix = scanner.getScanner().nextInt();
		scanner.getScanner().nextLine();
		return choix;
		
	}
}
