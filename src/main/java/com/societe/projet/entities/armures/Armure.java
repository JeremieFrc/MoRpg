package com.societe.projet.entities.armures;

public abstract class Armure {

	
	//************************************************//
	//	 @private
	//***********************************************//

	private int defencePhysique;
	private int defenceMagic;
	
	//************************************************//
	//	 @Constructeur 
	//***********************************************//
	
	/**
	 * 
	 * @param defencePhysique
	 * @param defenceMagic
	 */
	
	public Armure() {}
	
	public Armure(int defencePhysique, int defenceMagic) {

		this.defencePhysique = defencePhysique;
		this.defenceMagic = defenceMagic;
	}
	
	//************************************************//
	//	 @Setter and @getter
	//***********************************************//

	public int getDefencePhysique() {
		return defencePhysique;
	}

	public void setDefencePhysique(int defencePhysique) {
		this.defencePhysique = defencePhysique;
	}

	public int getDefenceMagic() {
		return defenceMagic;
	}

	public void setDefenceMagic(int defenceMagic) {
		this.defenceMagic = defenceMagic;
	}
	
	public void affiArmure() {
		System.out.println("-----Armure -----------");
		System.out.println("nom : "+name);
		System.out.println("point de vie : "+pointVie);
		System.out.println("point action : "+pointAction);
		System.out.println("point attaque : "+pointAction);
	}
	
}
