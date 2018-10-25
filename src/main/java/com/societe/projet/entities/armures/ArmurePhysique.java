package main.java.com.societe.projet.entities.armures;

import java.util.ArrayList;
import java.util.List;

public class ArmurePhysique extends Armure {
	//************************************************//
	//	 @private
	//***********************************************//

	private List <ArmureMixte> listPhysiqye = new ArrayList<ArmureMixte>();
	
	//************************************************//
	//	 @Constructeur 
	//***********************************************//
	
	public ArmurePhysique(int defencePhysique, int defenceMagic) {
		super(defencePhysique, defenceMagic);
		// TODO Auto-generated constructor stub
	}
}
