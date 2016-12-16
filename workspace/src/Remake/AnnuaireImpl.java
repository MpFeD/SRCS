package Remake;

import java.rmi.RemoteException;

public class AnnuaireImpl implements Annuaire {
	private String nom;
	private String num;
	private Personne p;

	public AnnuaireImpl(String nom, String num) throws RemoteException {
		this.nom = nom;
		this.num = num;
	}

	@Override
	public void setNom(String nom) throws RemoteException {
		this.nom = nom;
	}

	@Override
	public void setNum(String num) throws RemoteException {
		this.num = num;
	}

	@Override
	public String getNom(String num) throws RemoteException {
		if (num.equals(this.num))
			return this.nom;
		return "";
	}

	@Override
	public void setPersonne(Personne p) throws RemoteException {
		this.p=p;
	}
	
	@Override
	public void setPersonne(String prenom, String adresse) throws RemoteException {
		this.p=new Personne(prenom, adresse);
	}

	@Override
	public Personne getPersonne() throws RemoteException {
		return p;
	}
	@Override
	public String getPrenom() throws RemoteException {
		return p.getPrenom();
	}
	@Override
	public int getCpt() throws RemoteException {
		return p.getCpt();
	}

	@Override
	public String getAdresse() throws RemoteException {
		return p.getAdresse();
	}
	

}
