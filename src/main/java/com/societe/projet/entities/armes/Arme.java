package com.societe.projet.entities.armes;

import com.societe.projet.entities.armures.Armure;

public abstract class Arme  {
	//************************************************//
	//	 @private
	//***********************************************//
	
	private int degatPhysique;
	private int degatMagic;
	private int cpa ; //point de consommation
	
	//************************************************//
	//	 @Constructeur 
	//***********************************************//	
	
	/**
	 * 
	 * @param degatMagic
	 * @param degatPhysique
	 * @param cpa
	 */
	public Arme() {}

	public Arme (int degatMagic, int degatPhysique,int cpa) {
		this.degatMagic = degatMagic;
		this.degatPhysique = degatPhysique;
		this.cpa = cpa;
	}
	//************************************************//
	//	 @Setter and @getter
	//***********************************************//	

	public int getDegatPhysique() {
		return degatPhysique;
	}

	public void setDegatPhysique(int degatPhysique) {
		this.degatPhysique = degatPhysique;
	}

	public int getdegatMagic() {
		return degatMagic;
	}

	public void setdegatMagic(int degatMagic) {
		this.degatMagic = degatMagic;
	}

	public int getCpa() {
		return cpa;
	}

	public void setCpa(int cpa) {
		this.cpa = cpa;
	}
	//************************************************//
	//	 @Methods 
   //***********************************************//
	public int attack(Armure armure) {
		int result = 0;

		result = this.getDegatPhysique()-this.getdegatMagic() - armure.getDefenceMagic()- armure.getDefencePhysique();

		return result > 0 ? result : 0; //application ternaire
	}

}
