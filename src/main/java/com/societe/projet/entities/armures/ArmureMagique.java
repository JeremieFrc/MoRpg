package main.java.com.societe.projet.entities.armures;

import java.util.ArrayList;
import java.util.List;

public class ArmureMagique extends Armure {
	//************************************************//
	//	 @private
	//***********************************************//	
	
	private List <ArmureMixte> listPhysique = new ArrayList<ArmureMixte>();
	
	//************************************************//
	//	 @Constructeur 
	//***********************************************//
	public ArmureMagique(int defencePhysique, int defenceMagic) {
		super(defencePhysique, defenceMagic);
		// TODO Auto-generated constructor stub
	}

}
