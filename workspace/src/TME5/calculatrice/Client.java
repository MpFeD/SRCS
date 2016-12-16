package TME5.calculatrice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

import org.omg.CORBA.ORB;
import org.omg.CORBA.Object;

import TME5.table.tabledehachich;
import TME5.table.tabledehachichHelper;

public class Client {

	public Client() {
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

	public static void main(String[] args) {

		Client c = new Client();
		Properties props = new Properties();
		props.put("org.omg.CORBA.ORBInitialPort", "1050");
		props.put("org.omg.CORBA.ORBInitialHost", "localhost");
		ORB orb = ORB.init(args, props);
		// Fichier ior
		 //ORB orb = ORB.init(args, null);
		// org.omg.CORBA.Object obj = c.restoreIOR("compte.ior", orb);
		// fonctions f = fonctionsHelper.narrow(obj);

		// Resolution de nom
		String url = "corbaname::localhost:1050#Bob";
		org.omg.CORBA.Object obj = orb.string_to_object(url);
		
		
		tabledehachich f = tabledehachichHelper.narrow(obj);
		
		fonctionsOperations n = fonctionsHelper.narrow(f.get("allo"));
	
		System.out.println(f.contains("allo"));
		f.put("allo", obj);

		System.out.println(n.add(3, 6));
	}
}
