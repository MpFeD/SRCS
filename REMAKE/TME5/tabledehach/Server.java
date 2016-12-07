package tabledehach;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

public class Server{

    public static void save (String fileName, ORB orb, org.omg.CORBA.Object obj) {
	String ior = orb.object_to_string(obj);
	FileWriter fw;
	try {
	    fw = new FileWriter(fileName);
	    fw.write(ior);
	    fw.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    public static void main(String[] args) {
	try{
	    ORB orb = ORB.init(args, null);
	    org.omg.CORBA.Object rootobj = orb.resolve_initial_references("RootPOA");
	    POA poa = POAHelper.narrow(rootobj);
	    poa.the_POAManager().activate(); 
	    tabledehach.ModifPOA servant = new Implementation();	
	    org.omg.CORBA.Object obj =poa.servant_to_reference(servant);
	    save("fichier2.ior", orb, obj); 
	    orb.run();
	}catch(Exception e){
	}
    }
}
