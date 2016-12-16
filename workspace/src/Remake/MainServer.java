package Remake;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class MainServer {

	public static void main(String[] args) {
		try {
			Annuaire a = new AnnuaireImpl("Booba", "92izi");
			a.setPersonne("B2o", "92 les pyramides");
			UnicastRemoteObject.exportObject(a, 0);
			Registry r = LocateRegistry.createRegistry(1099);
			r.bind("Booba", a);

		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		}

	}

}
