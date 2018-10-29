package com.societe.projet.menu;

import java.util.Scanner;

import com.societe.projet.utils.ScannerProvider;

public class Menu {

	private ScannerProvider scanner;
	
	public Menu(ScannerProvider scanner) {
		this.scanner = scanner;
	}
	
	public int menuEquipe() {
		
		System.out.println("-------- creation menu equipe---------------");
		System.out.println("Creation equipe de HEROS [1] ");
		System.out.println("Creation equipe de Montre [2]");
		System.out.println("Exist [3]");
		
		
		return 1;
	}
	
	public int equipHero() {
		System.out.println("Creation equipe de HEROS  ");
		System.out.println("choix Heros  :paladin    [1]");
		System.out.println("choix heros  :magicien   [2]");
		System.out.println("choix heros  :barbare    [3]");
		return 0;
	}
	
	public void equipMonstre() {
			
	}
		
	
	
	
}
