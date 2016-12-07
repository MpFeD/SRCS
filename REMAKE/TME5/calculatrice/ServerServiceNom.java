package calculatrice;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

public class ServerServiceNom{

    public static void main(String[] args) {
	try{
	    Properties props = new Properties();
	    props.put("org.omg.CORBA.ORBInitialPort", "1050");
	    props.put("org.omg.CORBA.ORBInitialHost", "localhost");

	    ORB orb = ORB.init(args, props);
	    
	    org.omg.CORBA.Object ncobj = orb.resolve_initial_references("NameService");
	    org.omg.CORBA.Object rootobj = orb.resolve_initial_references("RootPOA");
	    
	    POA poa = POAHelper.narrow(rootobj);
	    poa.the_POAManager().activate();
	    calculatrice.OperationPOA servant = new Implementation();
	    
	    NamingContext nc = NamingContextHelper.narrow(ncobj);
	    NameComponent[] names = new NameComponent[] { new NameComponent("Bob", "") };
	    
	    org.omg.CORBA.Object obj =poa.servant_to_reference(servant);  
	    nc.rebind(names, obj);
	    orb.run();  
	}catch(Exception e){
	}
    }
}
