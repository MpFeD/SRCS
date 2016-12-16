package TME04;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class AnnuaireImpl implements Annuaire, Remote{
	private String nom;
	private String num;
	private Personne p;


	public AnnuaireImpl(String nom,String prenom, String num,String adresse) throws RemoteException{
		p = new Personne(101, 101);
		this.nom=nom;
		this.num=num;
	}
	
	public AnnuaireImpl(String nom, String num,Personne p) throws RemoteException{
		this.p=p;
		this.nom=nom;
		this.num=num;
	}

	public Object clone(){
		try {
			return new AnnuaireImpl(this.nom, this.num,this.p);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public void setNom(String nom) throws RemoteException {
		this.nom=nom;
	}

	public void setNum(String num) throws RemoteException {
		this.num=num;
	}

	public String getNum() throws RemoteException {
		return this.num;
	}
	
	public int getPrenom() throws RemoteException {
		return p.getPrenom();
	}
	
	public int getAdresse()throws RemoteException{
		return p.getAdresse();
	}
	
	public int getNfois()throws RemoteException{
		return p.getNfois();
	}

	public String getNom() throws RemoteException{
		return nom;
	}

	public Personne getP() throws RemoteException{
		return p;
	}

}
