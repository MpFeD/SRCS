package TME04;

import java.rmi.Remote;
import java.rmi.RemoteException;

public class PersonneImpl implements PersonneItf{
	/*par ref*/
	private int adresse;
	private int prenom;
	private int nbfois=0;
	
	public PersonneImpl(int p, int a) throws RemoteException{
		this.prenom=p;
		this.adresse=a;
	}

	@Override
	public int getAdresse() throws RemoteException {
		// TODO Auto-generated method stub
		return adresse;
	}

	@Override
	public int getPrenom() throws RemoteException {
		// TODO Auto-generated method stub
		return prenom;
	}

	@Override
	public int getNfois() throws RemoteException {
		// TODO Auto-generated method stub
		return ++nbfois;
	}
	
	@Override
	public void setPrenom(int a) throws RemoteException {
		this.prenom=a;
	}


}
