package TME04;

import java.io.Serializable;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

	public static void main(String args[]) {

		try {
			Registry registry = LocateRegistry.getRegistry(1100);
			PersonneItf p1 = (PersonneItf) registry.lookup("bob");
			Annuaire b = (Annuaire) registry.lookup("allo");
			Personne p=b.getP();
			/*
			System.out.println("mon num est " + a.getNum() + " mon prenom est "
					+ a.getPrenom() + " mon adresse est " + a.getAdresse() + "\nnb fois recherche : "+a.getNfois());
			*/
			
			System.out.println(p1.getPrenom());
			
			
			System.out.println(p.getPrenom());
			
			
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			/*System.out.println("mon num est " + a.getNum() + " mon prenom est "
					+ a.getPrenom() + " mon adresse est " + a.getAdresse() + "\nnb fois recherche : "+a.getNfois());*/
			
			System.out.println(p1.getPrenom());	
			
			
			System.out.println(p.getPrenom());
		
			/*
		
			Annuaire c = (Annuaire) registry.lookup("allo");
			System.out.println("mon num est " + c.getNum() + " mon prenom est "
					+ c.getPrenom() + " mon adresse est " + c.getAdresse() + "\nnb fois recherche : "+c.getNfois());
		
			
			a.setNum("010101");

			a = (Annuaire) registry.lookup("bob");
			System.out.println("mon num est " + a.getNum() + " mon prenom est "
					+ a.getPrenom() + " mon adresse est " + a.getAdresse() + "\nnb fois recherche : "+a.getNfois());
			
			
			System.out.println("mon num est " + c.getNum() + " mon prenom est "
					+ c.getPrenom() + " mon adresse est " + c.getAdresse() + "\nnb fois recherche : "+c.getNfois());
		
			*/
			
		} catch (RemoteException | NotBoundException e) {
			e.printStackTrace();
		}

	}
}
