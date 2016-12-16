package TME04;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface Annuaire extends Remote{
	public void setNom(String nom) throws RemoteException;
	public void setNum(String num) throws RemoteException;
	public String getNum() throws RemoteException;
	public int getAdresse() throws RemoteException;
	public int getPrenom() throws RemoteException;
	public int getNfois() throws RemoteException;
	public Personne getP() throws RemoteException;
}
