package Remake;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Annuaire extends Remote {
	public void setNom(String nom) throws RemoteException;
	public void setNum(String num) throws RemoteException;
	public String getNom(String num) throws RemoteException;
	public void setPersonne(Personne p) throws RemoteException;
	public Personne getPersonne() throws RemoteException;
	public void setPersonne(String prenom, String adresse) throws RemoteException;
	public String getPrenom() throws RemoteException;
	public int getCpt() throws RemoteException;
	public String getAdresse() throws RemoteException;
}
