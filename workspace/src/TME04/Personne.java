package TME04;

import java.io.Serializable;
import java.rmi.server.RemoteObject;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.Remote;
import java.rmi.RemoteException;
public class Personne implements Serializable{

	/*Par copie */
	public int prenom;
	public int adresse;
	public int nfois = 0;	


	public Personne(int a, int b){
		prenom = a;
		adresse = b;
	}

	public int getPrenom() {
		return prenom;
	}

	public void setPrenom(int prenom) {
		this.prenom = prenom;
	}

	public int getAdresse() {
		return adresse;
	}

	public void setAdresse(int adresse) {
		this.adresse = adresse;
	}

	public int getNfois() {
		return ++nfois;
	}
	
	

}
