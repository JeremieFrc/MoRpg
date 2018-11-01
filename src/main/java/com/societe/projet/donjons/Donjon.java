package com.societe.projet.donjons;

import java.util.ArrayList;
import java.util.List;

import com.societe.projet.databases.contracts.armes.ArmeMagiqueContract;
import com.societe.projet.databases.dao.DAOManager;
import com.societe.projet.databases.dto.ArmeMagiqueDTO;
import com.societe.projet.defaultfighter.DefaultBarbare;
import com.societe.projet.defaultfighter.DefaultMagicien;
import com.societe.projet.defaultfighter.DefaultPaladin;
import com.societe.projet.entities.armes.Arme;
import com.societe.projet.entities.armes.ArmeMagique;
import com.societe.projet.entities.armures.Armure;
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
	
	private List<Monstre> listMonstre = new ArrayList<Monstre>();
	private List <Hero> listHeros= new ArrayList<Hero>();
	
	
	private List <Personnage> listPersonnage = new ArrayList<Personnage>();
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
	public void interfaceGame() {	
		
		//menu.screenGame();
		//nbJoueurGame = menu.initNbJoueurs();
		//nbEtages = menu.nbEtage();
		
		//init les element
		//this.createElementPersonnage(0,nbJoueurGame[0]);
		//this.createElementPersonnage(1,nbJoueurGame[1]);
		
		//this.methodTest(); //unitair
		
		this.methodTestinitArme();
		//this.initArmeEquipe(listHeros);	
		this.initArmeEquipeV2(listHeros);	
		
		//((Personnage) listHeros.get(0)).setArme(new ArmeMagique("hache",12,120));//init arme sur heros or monstre
		//listHeros.get(0).setArme(new ArmeMagique("hache",12,120));//init arme sur heros or monstre
		//System.out.println(listHeros.size());
		
		//System.out.println("cccccc");
		//listHeros.get(0).getArme().affiArme();
	}
	
	
	/*
	 * 
	 * 
	 */
	
	public <T> void initArmeEquipe(List<T> liste) {
		System.out.println("Select arme : ");
		
		for(T valeur : liste) { //for int i at length
			switch(verifiedTyp(valeur)) {
			case 1 :
				System.out.println("Paladin arme possible a équiper");
				
				//init arme palldin arme
				DAOManager<ArmeMagique> armDAOManager = new DAOManager<>();
				ArrayList<ArmeMagique> armgic = armDAOManager.selectAllJoin(new ArmeMagiqueContract(), new ArmeMagiqueDTO());
				affArmre(armgic);
				
				System.out.print("\nchoix : ");
				int choix = scanners.getScanner().nextInt() - 1;
				scanners.getScanner().nextLine();
				
				//init list personnage a une arme
				
				armgic.get(choix).affiArme();
				
				break;
			
			case 2 : 
				System.out.println("Perso est Barbare");
				break;
			case 3 : 
				System.out.println("Perso est Magiciens");
				break;
			}
		}
	}	
	
	public <T> void initArmeEquipeV2(List<T> liste) {
		System.out.println("\nSelect arme : \n\n");
		for(int i=0;i<liste.size();i++) {
			switch(verifiedTyp(liste.get(i))) {
			case 1 :
				System.out.println("Paladin arme possible a équiper");
				
				//init arme palldin arme
				DAOManager<ArmeMagique> armDAOManager = new DAOManager<>();
				ArrayList<ArmeMagique> armgic = armDAOManager.selectAllJoin(new ArmeMagiqueContract(), new ArmeMagiqueDTO());
				affArme(armgic);
				
				System.out.print("\nchoix : ");
				int choix = scanners.getScanner().nextInt() - 1;
				scanners.getScanner().nextLine();
				
				//init list personnage a une arme
				((Personnage) liste.get(i)).setArme(armgic.get(choix));//init arme sur heros or monstre
				//armgic.get(choix).affiArme();
				System.out.println("cccccc");
				((Personnage) liste.get(i)).getArme().affiArme();
				((Personnage) liste.get(i)).affichePersonnage();
				
				if(((Personnage)liste.get(i)).getArme() instanceof ArmeMagique){
					System.out.println("instance magicuqe arme");
				}
				
				break;
			
			case 2 : 
				System.out.println("Perso est Barbare");
				break;
			case 3 : 
				System.out.println("Perso est Magiciens");
				
				
				
				break;
			}
		}
	}
	public <T> void initPersArme(int valeur,List<T> liste) {
		((Personnage) liste.get(valeur)).setArme(new ArmeMagique("hache",12,120));//init arme sur heros or monstre
	}
	
	/*
	 * 
	 * 
	 * Base de donnees methode
	 */
	
	public static <T> void affArme(List <T> item) {
		for (T a : item) {
			((Arme) a).affiArme();
		}
	}
	public static <T> void affArmure(List <T> item) {
		for (T a : item) {
			((Armure) a).affiArmure();
		}
	}
	public <T> void initPersoArme(T person) {
		///init les element
	}
	
	/*
	 * 
	 * 
	 */
	
	
 	public void createElementPersonnage(int equipe,int nbJoueurGame) {
		//int response = 0;
		int compteur = 0;
		
		while(compteur < nbJoueurGame) {
			switch(equipe) {
			case 0 : 
				System.out.println("\n-----Personnage Heros -------\n ");
				Personnage hero = new Hero();
				createPersonnage(hero,equipe,nbJoueurGame); compteur++;
				break;
			case 1 :
				System.out.println("\n-----Personnage Monstre  -------\n ");
				Personnage monstre  = new Monstre();
				createPersonnage(monstre,equipe,nbJoueurGame); compteur++;
				break;
			default : 
				System.out.println("Error de selection");
				menu.menuEquipe();
				break;
			}
		}
	}
	public void createPersonnage(Personnage pers,int equipe,int nbJoueurGame) {
		
				int response = menu.affCreatePerso(nbJoueurGame);
				switch(response) {
					case 1:
						 System.out.println("\n---- Paladin --------\n ");
						 //creation paladin
						 pers.setRpg(new DefaultPaladin()); //init de type paladin
						 initPerson(pers,equipe);
						 break;
					case 2:
						System.out.println("\n---- Magicien --------\n ");
						//creation Magicien
						pers.setRpg(new DefaultMagicien()); 
						initPerson(pers,equipe);
						break;
					case 3:
						System.out.println("\n---- Barbare --------\n ");
						//creation barbare
						pers.setRpg(new DefaultBarbare()); 
						initPerson(pers,equipe);
						break;
					default:
						System.out.println("error de selection type Personnage");
						break;
				}	
	}
	public void initPerson(Personnage per,int equipe) {
		
		//scanners.getScanner().nextLine();
		//verifiedType(per);	
		
		System.out.print("Nom : ");
		per.setName(scanners.getScanner().nextLine());
		
		System.out.print("vie: ");
		per.setPointVie(scanners.getScanner().nextInt());
		scanners.getScanner().nextLine();	
		
		System.out.print("point action: ");
		per.setPointAction(scanners.getScanner().nextInt());
		scanners.getScanner().nextLine();
		
		System.out.print("point attaque: ");
		per.setPointAttaque(scanners.getScanner().nextInt());
		scanners.getScanner().nextLine();
		
		//personne.affichePersonnage();
		
		if(equipe == 0) {
			//System.out.println("inserer equipe heros");
			listHeros.add((Hero) per);
		}else {
			//System.out.println("inserer equipe monstre");
			listMonstre.add((Monstre) per);
		}	
	}	
	public void verifiedType(Personnage perso) {
		 if( perso.getRpg() instanceof Paladin ) {
			 System.out.println("Ceci est bien une instance de type Paladin");
		 }else if( perso.getRpg() instanceof Barbare ) {
			 System.out.println("Ceci est bien une instance de type Barbare");
		 }else if( perso.getRpg() instanceof Magiciens ) {
			 System.out.println("Ceci est bien une instance de type Magicien");
		 }
	}
	public <T> int verifiedTyp(T perso) {
		int response = 0 ; 
		if( ((Personnage) perso).getRpg() instanceof Paladin ) {
			response = 1;
		 }else if( ((Personnage) perso).getRpg() instanceof Barbare ) {
			 response = 2;
		 }else if( ((Personnage) perso).getRpg() instanceof Magiciens ) {
			 response = 3;
		 }
		return response;
	}
	public <T> void verifiedType(T perso) {
		 if( ((Personnage) perso).getRpg() instanceof Paladin ) {
			 System.out.println("Ceci est bien une instance de type Paladin");
		 }else if( ((Personnage) perso).getRpg() instanceof Barbare ) {
			 System.out.println("Ceci est bien une instance de type Barbare");
		 }else if( ((Personnage) perso).getRpg() instanceof Magiciens ) {
			 System.out.println("Ceci est bien une instance de type Magicien");
		 }
	}
	public <T> void afficheList(List<T> list) {
		for(T valeur : list) {
			this.verifiedType(valeur);
			((Personnage) valeur).affichePersonnage();
		}
	}

	//************************************************//
	//	 @Test unitaire
	//***********************************************//

	public void methodTestinitArme() {
		
		Personnage p = new Hero();
		initPerson(p,0);
		p.setRpg(new DefaultPaladin());
		verifiedType(p);
	}
	
	
	
	
	public void methodTest() {
		//this.afficheList(listPersonnage);	
		
		Personnage p = new Hero();
		p.setRpg(new DefaultPaladin());
		//verifiedType(p);
		listHeros.add((Hero) p);
		
		Personnage pp = new Hero();
		pp.setRpg(new DefaultMagicien()); 
		//verifiedType(pp);
		listHeros.add((Hero) pp);
		
		Personnage ppp = new Hero();
		ppp.setRpg(new DefaultBarbare());
		//verifiedType(ppp);
		listHeros.add((Hero) ppp);
	
		for(Personnage pc : listHeros) {
			verifiedType(pc);
		}
		//this.afficheList(listPersonnage);	
	}

}
