package cache;

import java.io.FileWriter;
import java.io.IOException;

import org.omg.CORBA.ORB;

import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;


import TME6.cache.FileSystemImpl;

public class Server {
	
	public Server() {
	}

	void saveIOR(String fileName, ORB orb, org.omg.CORBA.Object obj) {
		String ior = orb.object_to_string(obj);
		// représentation sous forme de string de l’ior
		FileWriter fw;
		try {
			fw = new FileWriter(fileName);
			// un flux de sortie vers un fichier
			fw.write(ior);
			// rempli avec l’ior
			fw.close();
			// et fermé
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void main(String args[]) throws Exception {
		System.out.println("Ici se trouve le code du serveur");
		
		try {
			Server s = new Server();
			ORB orb = ORB.init(args, null);
			org.omg.CORBA.Object rootobj = orb
					.resolve_initial_references("RootPOA");
			POA poa = POAHelper.narrow(rootobj);
			poa.the_POAManager().activate();

			FileSystemPOA servant = new FileSystemImpl();
			
			
			// Fichier ior
			org.omg.CORBA.Object obj = poa.servant_to_reference(servant);
			s.saveIOR("compte.ior", orb, obj);
			

			

			// Fin
			orb.run();
		} catch (Exception e) {
		}
	}
}
