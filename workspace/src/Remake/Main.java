package Remake;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {

	public static void main(String[] args) {
		// Chiffrement c = new Chiffrement("/users/nfs/Etu5/3000755/abc");
		Registry r;
		try {
			r = LocateRegistry.getRegistry(1099);
			Annuaire a = (Annuaire) r.lookup("Booba");
			System.out.println("le numéro associé a 92izi est "
					+ a.getNom("92izi") + " son prenom est "
					+ a.getPrenom() + "son adresse est "
					+ a.getAdresse()+ "nombre de fois recherché : "+ a.getCpt());

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
