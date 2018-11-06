package com.societe.projet.donjons;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.societe.projet.databases.contracts.Contract;
import com.societe.projet.databases.contracts.armes.ArmeMagiqueContract;
import com.societe.projet.databases.contracts.armes.ArmePhysiqueContract;
import com.societe.projet.databases.contracts.armures.ArmureMagiqueContract;
import com.societe.projet.databases.contracts.armures.ArmurePhysicContract;
import com.societe.projet.databases.dao.DAOManager;
import com.societe.projet.databases.dto.ArmeMagiqueDTO;
import com.societe.projet.databases.dto.ArmePhysiqueDTO;
import com.societe.projet.databases.dto.ArmureMagiqueDTO;
import com.societe.projet.databases.dto.ArmurePhysiqueDTO;
import com.societe.projet.databases.dto.DTO;
import com.societe.projet.defaultfighter.DefaultBarbare;
import com.societe.projet.defaultfighter.DefaultFighter;
import com.societe.projet.defaultfighter.DefaultMagicien;
import com.societe.projet.defaultfighter.DefaultPaladin;
import com.societe.projet.entities.armes.Arme;
import com.societe.projet.entities.armes.ArmeMagique;
import com.societe.projet.entities.armes.ArmePhysique;
import com.societe.projet.entities.armures.Armure;
import com.societe.projet.entities.armures.ArmureMagique;
import com.societe.projet.entities.armures.ArmurePhysique;
import com.societe.projet.entities.personnages.Hero;
import com.societe.projet.entities.personnages.Monstre;
import com.societe.projet.entities.personnages.Personnage;
import com.societe.projet.menu.Menu;
import com.societe.projet.rpg.Barbare;
import com.societe.projet.rpg.Magiciens;
import com.societe.projet.rpg.Paladin;
import com.societe.projet.rpg.Rpg;
import com.societe.projet.utils.ScannerProvider;

/**
 * 
 * @author Jeremie
 */

public class Donjon { 
	
	/*
	*************************************************
	*    @Private
	*************************************************
	 */
	
	private ScannerProvider scanners;
	
	
	private String nom;
	
	private int nbEtages;
	private int nbJoueurGame[];
	private Menu menu;
	
	private List<Monstre> listMonstre = new ArrayList<Monstre>();
	private List <Hero> listHeros= new ArrayList<Hero>();
	
	
	private List <ArrayList<Monstre>> listEtages = new ArrayList<ArrayList<Monstre>>();
	
	private int nbMonstreEtage;
	
	
	private Personnage personne;
	
	/*
	*************************************************
	*    @Constructor
	*************************************************
	 */
	
	public Donjon() {}
	public Donjon(ScannerProvider scanners) {
		this.scanners = scanners;
	}
	
	/*
	*************************************************
	*    @getter setter
	*************************************************
	 */	 
	
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
	/*
	*************************************************
	*    @Default heros, monstre life
	*************************************************
	 */	  

	public Donjon setDefaultHero(Rpg rpg){
		this.personne = new Hero();
		this.personne.setName(nom);
		this.personne.setRpg(rpg);
		return this; //return element qui utilise courant
	}
	public Donjon setDefaultMontre(Rpg rpg){
		this.personne = new Monstre();
		this.personne.setName(nom);
		this.personne.setRpg(rpg);
		return this; //return element qui utilise courant
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
	public void setPersonne(Personnage personne) {
		this.personne = personne;
	}
	
	
	public void setDefautllAttrVie(Personnage personDefault) {
		personDefault.setName("defaultPers");
		personDefault.setPointVie(100);
		personDefault.setPointAction(12);
		personDefault.setPointAttaque(20);
	}
	
	public void setDefaultEquipment(Personnage persoDefautlt){
		if (persoDefautlt.getRpg() instanceof Barbare) {
			System.out.println("Equipement default barbare");
			
			persoDefautlt.setArme(new ArmePhysique("defaultArme",3, 2));
			persoDefautlt.setArmure(new ArmurePhysique(3));
			persoDefautlt.getArmure().setNom("defaultArmure");
		
		}else if (persoDefautlt.getRpg() instanceof Magiciens) {
			System.out.println("Equipement default Magicient");
			
			persoDefautlt.setArme(new ArmeMagique("defaultArme",3, 2));
			persoDefautlt.setArmure(new ArmureMagique(3));
			persoDefautlt.getArmure().setNom("defaultArmure");
			
		}else if (persoDefautlt.getRpg() instanceof Paladin) {
			System.out.println("Equipement default Paladin");
			
			persoDefautlt.setArme(new ArmeMagique("defaultArme",20,112));
			persoDefautlt.setArmure(new ArmureMagique(16));
			persoDefautlt.getArmure().setNom("defaultArmure");
			
		}else{
			System.out.println("Equipement default Fighter");
			
			persoDefautlt.setArme(new ArmePhysique("defaultArme",2,2));
			persoDefautlt.setArmure(new ArmurePhysique(1));
			persoDefautlt.getArmure().setNom("defaultArmure");
		}
	}
	
	/*
	*************************************************
	*    @menu and interaction User
	*************************************************
	 */	
	
	public void initMenu() {
		this.menu = new Menu(scanners);
	}
	public void interfaceGame() {	
		
		menu.screenGame();     									     //def : ok
		
		/*
		*************************************************
		*    @Init element equipe/Etages
		*************************************************
		 */
		
		nbJoueurGame = menu.initNbJoueurs();						 //def : ok
		nbEtages = menu.nbEtage();								     //def : ok
		
		/*
		*************************************************
		*    @Init element nbJoueur
		*************************************************
		 */	
		
		System.out.println("-----------------------------");
		this.createElementPersonnage(0,nbJoueurGame[0]); 			//def : ok
		System.out.println("-----------------------------");
		this.createElementPersonnage(1,nbJoueurGame[1]);			//def : ok
		
		
		/*
		*************************************************
		*    @Init ArmeEquipement
		*************************************************
		 */
		
		System.out.println("-----------------------------");
		this.initArmeEquipe(listHeros);                                //def : ok
		System.out.println("-----------------------------");
		this.initArmeEquipe(listMonstre);								//def : ok
		System.out.println("-----------------------------");
		
		/*
		*************************************************
		*    @Init ArmureEquipement
		*************************************************
		 */
		
		this.initArmureEquipe(listHeros);								//def : ok
		System.out.println("-----------------------------");
		this.initArmureEquipe(listMonstre);							   //def : ok
		
		/*
		*************************************************
		*    @Init EtageMontre
		*************************************************
		 */
		
		this.nbMonstreEtage(menu.menuMonstreEtage(listMonstre.size()));    //def : ok
		this.initEtageMonstre();										   //def : ok
		this.affListEtage();	
	}
	
	/*
	*************************************************
	*    @ debut Test unitaire games
	*************************************************
	 */
	
	public void game() {
		System.out.println("\n\n\n--------Lancementt Jeux -----------");
		
		
		Personnage monstre = new Monstre();
		monstre.setName("monstre");
		monstre.setRpg(new DefaultBarbare(monstre)); //barbare
		listMonstre.add((Monstre)monstre);
		
		Personnage mon = new Monstre();
		mon.setName("mon");
		Rpg rpgb = new DefaultBarbare(mon);
		mon.setRpg(rpgb);
		listMonstre.add((Monstre)mon);
		///////////////////////////////////////
		
		Personnage heros = new Hero();
		heros.setName("heros");
		heros.setRpg(new DefaultBarbare(heros)); //barbare
		listHeros.add((Hero) heros);
		
		Personnage heros2 = new Hero();
		heros2.setName("heros2");
		heros2.setRpg(new DefaultMagicien(heros2));
		
		listHeros.add((Hero) heros2);
		
		/////////////////////////////////////
		
		this.initPersonGeneric(heros);
		this.initPersonGeneric(heros2);
		this.initPersonGeneric(monstre);
		this.initPersonGeneric(mon);
		
		
		
		/////////////////////////////////////
		
		heros.setArme(new ArmePhysique("armpheros",48,48));
		heros2.setArme(new ArmeMagique("armpheros2",48,48));
		monstre.setArme(new ArmePhysique("armpmonstre",148,148));
		mon.setArme(new ArmePhysique("armpmonstre",148,148));
		
		//////////////////////////////////////////////
		heros.setArmure(new ArmurePhysique(40));
		heros2.setArmure(new ArmureMagique(40));
		monstre.setArmure(new ArmurePhysique(40));
		mon.setArmure(new ArmurePhysique(40));

		//////////////////////////////////
		
		
		//heros.affichePersonnage();
		//heros.getArme().affiArme();
		//heros.getArmure().affiArmure();
		
		
		//////////////////////////////////
		
		//listHeros.get(0).getRpg().figth(listMonstre.get(0)); //m//bb
		//listHeros.get(0).getRpg().figth(listMonstre.get(0)); //bb//bb
		//listMonstre.get(0).getRpg().figth(listHeros.get(0));
		
		//////////////////////////////////
		
		int dieMonstre = listMonstre.size();
		int dieHeros = listHeros.size();
		int toogle = 0;
		boolean win = false;
		
		int nextHero = 0;
		//////////////////////////////////
		nbEtages =1;
		nbMonstreEtage = 2;
		initEtageMonstre();
		//////////////////////////////////
		
		System.out.println(listEtages.size());
		for(ArrayList<Monstre> lisMonstre : listEtages) {
			System.out.println("\n\n\n\n\n\nEtages");
			for(Monstre mtr : lisMonstre) {
				mtr.affichePersonnage();
				mtr.getArme().affiArme();
				mtr.getArmure().affiArmure();
				
				combatListEtage(dieMonstre ,dieHeros,mtr,nextHero);
			
			}	
		}
		
		
		
		while((dieMonstre!= 0 || dieHeros!=0) && !win) {
			
			if(toogle == 0) {
				listHeros.get(0).getRpg().figth(listMonstre.get(0));
				
				if(verifiedLife(listMonstre.get(0))) {
					win = true;
					dieMonstre--;
					System.out.println("winner is Equipe Heros");
				}
				toogle++;
			}else {
				listMonstre.get(0).getRpg().figth(listHeros.get(0));
				
				if(verifiedLife(listHeros.get(0))) {
					win = true;
					dieHeros--;
					System.out.println("winner is Equipe monstre");
				}
				toogle--;
			}
		}

			
	}
	
	public void eeee() {
		
		System.out.println(listEtages.size());
		for(ArrayList<Monstre> valeur1 : listEtages) {
			System.out.println("\n\n\n\n\n\nEtages");
			for(Monstre valeur2 : valeur1) {
				valeur2.affichePersonnage();
				valeur2.getArme().affiArme();
				valeur2.getArmure().affiArmure();
			
			
			}	
		}
	}
	
	
	public  boolean verifiedLife(Personnage item) {
		boolean response = false;
		if(item.getPointVie()<0) {
			response = true;
		}
		return response;
	}
	
	
	public void combatListEtage(int dieM,int dieH,Personnage monst,int nHeros) {
	
	    int toogle = 0;
		boolean win = true;
		
		while((dieM!= 0 || dieH!=0) && !win) {
			
			if(toogle == 0) {
				listHeros.get(nHeros).getRpg().figth(monst);
				
				if(verifiedLife(monst)) {
					win = true;
					dieM--;
					System.out.println("winner is Heros");
				}
				toogle++;
			}else {
				monst.getRpg().figth(listHeros.get(nHeros));
				
				if(verifiedLife(listHeros.get(nHeros))) {
					win = true;
					nHeros++;
					dieH--;
					System.out.println("winner is monstre");
				}
				toogle--;
			}
		}

	}

	
	public void initPersonGeneric(Personnage perso) {
		 perso.setPointVie(200);
		 perso.setPointAttaque(200);
		 perso.setPointAction(100);
	}

	
	
	/*
	*************************************************
	*    @Init List Etage Monstre
	*************************************************
	 */

	public void nbMonstreEtage(int nbMonstrEtage) {				//def : ok
		int totalMonstre = listMonstre.size();
		nbMonstreEtage = nbMonstrEtage;
		
		System.out.println("size : "+listMonstre.size());
		
		if((nbMonstrEtage > 0)  && (nbEtages*nbMonstrEtage != totalMonstre) && (nbEtages*nbMonstrEtage > totalMonstre)  ) {
			
			System.out.println(totalMonstre+" monstres insuffissant IA add montres default");
			
			//add monstre default a la listMonstre
			
			Personnage genericMonstre = new Monstre();
			this.setDefautllAttrVie(genericMonstre);
			
			switch(altRamdDefaultInstance()) {
				case 1 :
					System.out.println("default barbare");
					genericMonstre.setRpg(new DefaultBarbare());
					break;
				case 2:
					System.out.println("default Paladin");
					genericMonstre.setRpg(new DefaultPaladin());
					break;
				case 3:
					System.out.println("default magicien");
					genericMonstre.setRpg(new DefaultMagicien());
					break;
				case 4 :
					System.out.println("default Fighter");
					genericMonstre.setRpg(new DefaultFighter());
					break;
			}
			setDefaultEquipment(genericMonstre);
			//insert list monstre
			listMonstre.add((Monstre) genericMonstre); 
			
			nbMonstreEtage(nbMonstrEtage);
		
		}else if((nbMonstrEtage < 0 ) || (nbEtages*nbMonstrEtage < totalMonstre) ){
			System.out.println("error de saisie");
			this.nbMonstreEtage(menu.menuMonstreEtage(listMonstre.size()));
		}
	}
	
	public int altRamdDefaultInstance() {	                    //def : ok
			 int x = (int)(Math.random() * 4)%4 +1;
			 System.out.println(x);
			 return x;
	}
	
	public void initEtageMonstre() {							//def : ok
		int compteur = 0 ;
		
		for(int i=0 ; i < nbEtages  ; i++) {
			System.out.print(" etage["+i+"] ");
			List <Monstre> temp = new ArrayList<Monstre>();
			for(int j = 0; j < nbMonstreEtage ;j++) {
				    temp.add(listMonstre.get(compteur));
					compteur = compteur+1;	
			}
			listEtages.add((ArrayList<Monstre>) temp);	
			System.out.println("");	
		}	
	}
	
	public void affListEtage() {								//def : ok
		for(ArrayList<Monstre> valeur1 : listEtages) {
			System.out.println("\n\n\n\n\n\nEtages");
			for(Monstre valeur2 : valeur1) {
				valeur2.affichePersonnage();
			}	
		}
	}
	
	/*
	*************************************************
	*    @Init ArmureEquipement
	*************************************************
	 */
	
	public <T> void initArmureEquipe(List<T> liste) {     							//def : ok				
		System.out.println("\n\n\n--------- Select armuree ----------------");
		
		for(int i=0;i<liste.size();i++) {
			
			switch(verifiedTyp(liste.get(i))) {
			case 1 :
				System.out.println("Paladin armure possible a équiper");
				//init arme palldin arme mixte 
				ArrayList<ArmureMagique> armugic = null;
				ArrayList<ArmurePhysique> armuphs = null;
				
				if(selectMixteArme() == 1) {
					System.out.println("----Paladin équiper armure magique");
					DAOManager<ArmureMagique> armDAOManager = new DAOManager<>();
					armugic = armDAOManager.selectAllJoin(new ArmureMagiqueContract(), new ArmureMagiqueDTO());
					affEquipment(armugic);
				}else if(selectMixteArme() == 2) {
					System.out.println("----Paladin équiper armure physique");
					DAOManager<ArmurePhysique> armDAOManager = new DAOManager<>();
					armuphs = armDAOManager.selectAllJoin(new ArmurePhysicContract(), new ArmurePhysiqueDTO());
					affEquipment(armuphs);
				}
				if(armugic != null) {
					((Personnage) liste.get(i)).setArmure(armugic.get(this.initPersArmeArmure()));//init arme sur heros or monstre
				}else {
					((Personnage) liste.get(i)).setArmure(armuphs.get(this.initPersArmeArmure()));//init arme sur heros or monstre
				}
				break;
			
			case 2 : 
				System.out.println("----Barbare armure possible a équiper");
				//init arme Barbare
				DAOManager<ArmurePhysique> armpDAOManager = new DAOManager<>();
				ArrayList<ArmurePhysique> armp = armpDAOManager.selectAllJoin(new ArmurePhysicContract(), new ArmurePhysiqueDTO());
				affEquipment(armp);
				
				((Personnage) liste.get(i)).setArmure(armp.get(this.initPersArmeArmure()));//init arme sur heros or monstre
				
				break;
				
			case 3 : 
				System.out.println("----Magiciens armure possible a équiper");
				
				DAOManager<ArmureMagique> armgDAOManager = new DAOManager<>();
				ArrayList<ArmureMagique> armg = armgDAOManager.selectAllJoin(new ArmureMagiqueContract(), new ArmureMagiqueDTO());
				
				affEquipment(armg);
				
				//init list personne a une arme
				((Personnage) liste.get(i)).setArmure(armg.get(this.initPersArmeArmure()));//init arme sur heros or monstre
				this.verifInstanceArm(liste,i);
				break;
			}
		}
	} 
	
	/*
	*************************************************
	*    @Init ArmeEquipement
	*************************************************
	 */
	
	public <T> void initArmeEquipe(List<T> liste) {     							//def : ok
		System.out.println("\n\n\n--------- Select arme ---------------- ");
		
		for(int i=0;i<liste.size();i++) {
			
			switch(verifiedTyp(liste.get(i))) {
			case 1 :
				System.out.println("-----Paladin arme possible a équiper");
				//init arme palldin arme mixte 
				ArrayList<ArmeMagique> armgic = null;
				ArrayList<ArmePhysique> armphs = null;
				
				if(selectMixteArme() == 1) {
					System.out.println("-----Paladin équiper arme magique");
					DAOManager<ArmeMagique> armDAOManager = new DAOManager<>();
					armgic = armDAOManager.selectAllJoin(new ArmeMagiqueContract(), new ArmeMagiqueDTO());
					affEquipment(armgic);
				}else if(selectMixteArme() == 2) {
					System.out.println("-----Paladin équiper arme physique");
					DAOManager<ArmePhysique> armDAOManager = new DAOManager<>();
					armphs = armDAOManager.selectAllJoin(new ArmePhysiqueContract(), new ArmePhysiqueDTO());
					affEquipment(armphs);
				}
				if(armgic != null) {
					((Personnage) liste.get(i)).setArme(armgic.get(this.initPersArmeArmure()));//init arme sur heros or monstre
				}else {
					((Personnage) liste.get(i)).setArme(armphs.get(this.initPersArmeArmure()));//init arme sur heros or monstre
				}			
				//this.verifInstanceArm(liste,i);
				break;
			
			case 2 : 
				System.out.println("-----Barbare arme possible a équiper");
				//init arme Barbare
				DAOManager<ArmePhysique> armpDAOManager = new DAOManager<>();
				ArrayList<ArmePhysique> armp = armpDAOManager.selectAllJoin(new ArmePhysiqueContract(), new ArmePhysiqueDTO());
				affEquipment(armp);
				
				((Personnage) liste.get(i)).setArme(armp.get(this.initPersArmeArmure()));//init arme sur heros or monstre
				this.verifInstanceArm(liste,i);
				break;
				
			case 3 : 
				System.out.println("Magiciens arme possible a équiper");
				
				DAOManager<ArmeMagique> armgDAOManager = new DAOManager<>();
				ArrayList<ArmeMagique> armg = armgDAOManager.selectAllJoin(new ArmeMagiqueContract(), new ArmeMagiqueDTO());
				
				affEquipment(armg);
				
				//init list personne a une arme
				((Personnage) liste.get(i)).setArme(armg.get(this.initPersArmeArmure()));//init arme sur heros or monstre
				this.verifInstanceArm(liste,i);
				break;
			}
		}
	} 
	
	/*
	*************************************************
	*    @verified Saisie
	*************************************************
	 */
	
	public int selectMixteArme() {   												//def : ok
		int choix = 0;
		while((choix != 1) && (choix != 2)){
			System.out.println("Choix  Magique[1] Or Physique[2]");
			System.out.print("Choix : ");
			choix = scanners.getScanner().nextInt();
			scanners.getScanner().nextLine();
		}
		return choix;
	}
	
	
	public int initPersArmeArmure() {											    //def : ok
		//gestiion bouclage pour error
		System.out.print("\nchoix : ");
		int choix = scanners.getScanner().nextInt() - 1;
		scanners.getScanner().nextLine();
		return choix;
	}
	
	/*
	*************************************************
	*    @create personnage
	*************************************************
	 */
	
 	public void createElementPersonnage(int equipe,int nbJoueurGame) {				 //def : ok
		//int response = 0;
		int compteur = 0;
		
		while(compteur < nbJoueurGame) {
			switch(equipe) {
			case 0 : 
				System.out.println("\n\n\n-----Personnage Heros -------\n ");
				Personnage hero = new Hero();
				this.createPersonnage(hero,equipe,nbJoueurGame); compteur++;
				break;
			case 1 :
				System.out.println("\n\n\n-----Personnage Monstre  -------\n ");
				Personnage monstre  = new Monstre();
				this.createPersonnage(monstre,equipe,nbJoueurGame); compteur++;
				break;
			default : 
				System.out.println("Error de selection");
				menu.menuEquipe();
				break;
			}
		}
	}
	public void createPersonnage(Personnage pers,int equipe,int nbJoueurGame) {      //def : ok
		
				int response = menu.affCreatePerso(nbJoueurGame);
				switch(response) {
					case 1:
						 System.out.println("\n\n\n---- Paladin --------");
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
	public void initPerson(Personnage per,int equipe) {                              //def : ok
		
		scanners.getScanner().nextLine();
		
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
		
		if(equipe == 0) {
			listHeros.add((Hero) per);
		}else {
			listMonstre.add((Monstre) per);
		}	
	}	
	
	/*
	*************************************************
	*    @Verified type
	*************************************************
	 */
	
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
	
	public <T >void verifInstanceArm(List <T> listes,int valeur) {					//def : ok
		if(((Personnage)listes.get(valeur)).getArme() instanceof ArmeMagique){
			System.out.println("instance magique arme");
		}else if(((Personnage)listes.get(valeur)).getArme() instanceof ArmePhysique) {
			System.out.println("instance Physique arme");
		}
	}
	
	
	/*
	*************************************************
	*    @AffichList and aff type
	*************************************************
	 */
	
	public <T> void afficheList(List<T> list) {									//def : ok
		for(T valeur : list) {
			this.verifiedType(valeur);
			((Personnage) valeur).affichePersonnage();
		}
	}

	public static <T> void affEquipment(List <T> item) {						//def : ok
		int compteur = 1 ;
		for (T a : item) {	
			if( a instanceof Arme) {
				((Arme) a).affiArme();
			}else if (a instanceof Armure) {
				((Armure) a).affiArmure();
			}
			System.out.println("\nchoix : ["+compteur+"]");
			compteur++;
		}
	}
}
