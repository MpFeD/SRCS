package Remake;

import java.io.Serializable;

public class Personne implements Serializable {
	private int cpt = 0;
	String prenom;
	String adresse;
	
	public Personne(String prenom, String adresse){
		this.prenom=prenom;
		this.adresse=adresse;
	}
	
	public String getPrenom() {
		return prenom;
	}


	public String getAdresse() {
		return adresse;
	}
	
	
	public int getCpt(){
		return ++cpt;
	}

}
