package calculatrice;
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
	org.omg.CORBA.Object obj = restore("fichier.ior", orb);
        calculatrice.Operation operation = calculatrice.OperationHelper.narrow(obj);
	System.out.println("Resultat de 3 + 3 ="  + operation.add(3,3));
	try{
	    System.out.println("Resultat de 3 / 0 ="  + operation.div(3,0));
	}catch(DivisionParZeroException d){
	    System.out.println("L'exception est catch");
	}
    }    
}
