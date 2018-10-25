package main.java.com.societe.projet.utils;

import java.util.Scanner;

public class ScannerProvider {
	//************************************************//
	//	       private scanner
	//***********************************************//
	private Scanner scanner;
	//************************************************//
	//	       @constructor
	//*********************************************//
	private ScannerProvider(){
		this.scanner = new Scanner(System.in);
	}
	//************************************************//
	//	        $getters
	//***********************************************//	
			   
	 public Scanner getScanner() {
			  return scanner;
	}		
	//************************************************//
	//	        Singleton alone instance v2
	//***********************************************//	
			     
	/** Instance unique non pre initialisée */
	 private static ScannerProvider INSTANCE = null; 
			    
	/** Point d'accès pour l'instance unique singleton */
	public static synchronized ScannerProvider getInstance()
	{           
		if (INSTANCE == null){   
			INSTANCE = new ScannerProvider(); 
		}
			return INSTANCE;
	}
	//************************************************//
	//	    @methods
	//***********************************************//			
	public void clearFlux() {
		scanner.nextLine();
	}
	public void closeScanner() {
		scanner.close();
	}
		
		  //************************************************//
		  //	        @Etapes
		    
		 //   1- declaration scanner
		 //   2- declaration construct 
		 //   3-  getter scanner
		 //   4 instance 
		 //   get instance
		 //***********************************************//	
}
