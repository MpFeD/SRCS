package cache;

import java.io.BufferedReader;
import java.io.FileReader;

import org.omg.CORBA.ORB;
import org.omg.CORBA.StringHolder;

public class Client {
	
	public Client(){
	}
	
	org.omg.CORBA.Object restoreIOR(String fileName, ORB orb) {
		// ouverture du flux d’entrée
		BufferedReader br;
		String ior = null;
		try {
			/** Fichier ior */
			br = new BufferedReader(new FileReader(fileName));
			ior = br.readLine();
			// récupère l’ior enregistrée dans le fichier
			br.close();
			// ferme le flux
			/** */

		} catch (Exception e) {
			e.printStackTrace();
		}

		return orb.string_to_object(ior);
		// convertit la chaîne en object CORBA

	}
	
	
	public static void main(String args[]) throws Exception {
		System.out.println("Ici se trouve le code du client");
		
		Client c = new Client();
		// Fichier ior
		ORB orb = ORB.init(args, null);
		org.omg.CORBA.Object obj = c.restoreIOR("compte.ior", orb);
		FileSystem f = FileSystemHelper.narrow(obj);
		
		f.ecrire("/users/nfs/Etu5/3000755/morradorade", "allo");
		StringHolder sh = new StringHolder();
		f.lire("/users/nfs/Etu5/3000755/morradorade", sh);
		System.out.println(sh.value);
	}
}
