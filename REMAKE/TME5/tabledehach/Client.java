package tabledehach;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;
import org.omg.CORBA.ORB;
import org.omg.CORBA.Object;

public class Client {

    public static org.omg.CORBA.Object restore(String fileName, ORB orb) {
	BufferedReader br;
	String ior = null;
	try {
	    br = new BufferedReader(new FileReader(fileName));
	    ior = br.readLine();
	    br.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return orb.string_to_object(ior);
    }
    
    public static void main(String[] args) {
	ORB orb = ORB.init(args, null); 
	org.omg.CORBA.Object obj = restore("fichier2.ior", orb);
        tabledehach.Modif modif = tabledehach.ModifHelper.narrow(obj);
	modif.put(0,10);
	modif.put(1,11);
	modif.put(2,12);
	System.out.println(modif.containsKey(0));
	System.out.println(modif.containsKey(3));
	System.out.println(modif.get(2));
    }    
}
