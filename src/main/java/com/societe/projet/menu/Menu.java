package com.societe.projet.menu;

import java.util.Scanner;

public class Menu {

	private Scanner scanner;
	private String choix;
	
	public String getChoix() {
		return choix;
	}

	public void setChoix(String choix) {
		this.choix = choix;
	}

	public Menu(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public void menuEquipe() {
		
		boolean response = true;
		
		System.out.println("-------- creation menu equipe---------------");
		System.out.println("Creation equipe de HEROS [1] ");
		System.out.println("Creation equipe de Montre [2]");
		System.out.println("Exist [3]");
		
		
		choix = scanner.nextLine();
		
		while(response) {
			switch(choix) {
				case "1" : break;
				case "2" : break;
				case "3" : response = false; break;
			}
		}
	}
	
	public void equipHero() {
		
	}
	
	public void equipMonstre() {
			
	}
		
	
	
	
}
