package it.polito.tdp.lab05.model;

import java.util.*;

public class AnagrammiModel {
	
	
	 	   //uso un SET perchè non voglio duplicati e non mi importa l'ordine
	public Set<String> calcolaAnagrammi(String parola) {
		
		if(parola.length()==1) {				//CONDIZIONE DI TERMINAZIONE
			Set<String> result=new HashSet<>();
			result.add(parola);
			return result;
		}			//FINE IF
		else {
			Set<String> result=new HashSet<>();
		
			for(int i=0;i<parola.length();i++) {					//GENERAZIONE DI UNA NUOVA SOLUZIONE
				char lettera=parola.charAt(i);
				String restanti=parola.substring(0, i)+parola.substring(i+1);
			
				Set<String> anagrammiRestanti=calcolaAnagrammi(restanti); //CHIAMATA RICORSIVA
				for(String soluzione : anagrammiRestanti) {
					result.add(lettera+soluzione);
				}
			}
			return result; 
		}				//FINE ELSE
	}					//FINE FUNZIONE RICORSIVA
	
}
