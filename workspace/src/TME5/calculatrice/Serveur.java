package TME5.calculatrice;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import TME5.table.tabledehachichExt;
import TME5.table.tabledehachichPOA;

public class Serveur {

	public Serveur() {

	}

	public void saveIOR(String fileName, ORB orb, org.omg.CORBA.Object obj) {
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

	public static void main(String[] args) {
		try {
			Serveur s = new Serveur();
			//ORB orb = ORB.init(args, null);
			Properties props = new Properties();
			props.put("org.omg.CORBA.ORBInitialPort", "1050");
			props.put("org.omg.CORBA.ORBInitialHost", "localhost");
			ORB orb = ORB.init(args, props);
			org.omg.CORBA.Object rootobj = orb
					.resolve_initial_references("RootPOA");
			POA poa = POAHelper.narrow(rootobj);
			poa.the_POAManager().activate();

			//fonctionsPOA servant = new fonctionsOperationsExt();
			tabledehachichPOA servant = new tabledehachichExt();
			
			fonctionsPOA servant2 = new fonctionsOperationsExt();
			
			
			// Fichier ior
			// org.omg.CORBA.Object obj = poa.servant_to_reference(servant);
			// s.saveIOR("compte.ior", orb, obj);

			// Resolution de nom
	
			org.omg.CORBA.Object ncobj = orb
					.resolve_initial_references("NameService");
			NamingContext nc = NamingContextHelper.narrow(ncobj);
			
			NameComponent[] names = new NameComponent[] { 
					new NameComponent("Bob", "") 
			};
		
			org.omg.CORBA.Object obj = poa.servant_to_reference(servant);
			
			nc.rebind(names, obj);
			
			org.omg.CORBA.Object obj2 = poa.servant_to_reference(servant2);
		
			servant.put("allo", obj2);

			

			// Fin
			orb.run();
		} catch (Exception e) {
		}

	}
}
