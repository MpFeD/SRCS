package calculatrice;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;
import org.omg.CORBA.ORB;
import org.omg.CORBA.Object;

public class ClientServiceNom {
    
    public static void main(String[] args) {
	ORB orb = ORB.init(args, null);
	String url = "corbaname::localhost:1050#Bob";
	org.omg.CORBA.Object obj = orb.string_to_object(url);
        calculatrice.Operation operation = calculatrice.OperationHelper.narrow(obj);
	System.out.println("Resultat de 3 + 3 ="  + operation.add(3,3));
	try{
	    System.out.println("Resultat de 3 / 0 ="  + operation.div(3,0));
	}catch(DivisionParZeroException d){
	    System.out.println("L'exception est catch");
	}
    }    
}