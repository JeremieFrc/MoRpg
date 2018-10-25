package main.java.com.societe.projet.entities.armes;

public abstract class Arme  {
	//************************************************//
	//	 @private
	//***********************************************//
	
	private int degatPhysique;
	private int degatMagit;
	private int cpa ; //point de consommation
	
	//************************************************//
	//	 @Constructeur 
	//***********************************************//	
	
	/**
	 * 
	 * @param degatMagit
	 * @param degatPhysique
	 * @param cpa
	 */
	
	public Arme (int degatMagit, int degatPhysique,int cpa) {
		this.degatMagit = degatMagit;
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

	public int getDegatMagit() {
		return degatMagit;
	}

	public void setDegatMagit(int degatMagit) {
		this.degatMagit = degatMagit;
	}

	public int getCpa() {
		return cpa;
	}

	public void setCpa(int cpa) {
		this.cpa = cpa;
	}
	
}
