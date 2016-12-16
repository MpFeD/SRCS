package TME04;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {

	public static void main(String args[]) {

		try {
			PersonneImpl p1 = new PersonneImpl(101,101);
			
			//Annuaire a = new AnnuaireImpl("wesh", "par ref",p1);
			
			
			Personne p = new Personne(101,101);
			
			AnnuaireImpl b = new AnnuaireImpl("roger", "par copie", p);
			
			
			UnicastRemoteObject.exportObject(p1, 0);
			
			//UnicastRemoteObject.exportObject(a, 0);
			UnicastRemoteObject.exportObject(b, 0);
	
			Registry registry = LocateRegistry.createRegistry(1100);
			// Registry registry = LocateRegistry.getRegistry("serveur",1099);
			registry.bind("bob", p1);
			registry.bind("allo", b);
			
			
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//a.setNum("le num change");
			b.getP().setPrenom(200);
			p1.setPrenom(200);
			
			
			
		} catch (RemoteException | AlreadyBoundException e) {
			e.printStackTrace();
		}

	}

}
