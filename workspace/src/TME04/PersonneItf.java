package TME04;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PersonneItf extends Remote{
	public int getAdresse() throws RemoteException;
	public int getPrenom() throws RemoteException;
	public int getNfois() throws RemoteException;
	public void setPrenom(int Prenom) throws RemoteException;
}
