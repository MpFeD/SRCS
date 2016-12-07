package remake;
import javax.naming.*;
import java.util.*;


public class Client { 
    public static void main(String args[]) throws Exception {

	Hashtable<String,String> env = new Hashtable<String,String>();
	env.put(Context.PROVIDER_URL, "127.0.0.1:PORTNUMBER");	

	
	javax.naming.Context ic = new javax.naming.InitialContext(env);


	    DirectoryServerIF bean = (DirectoryServerIF) ic.lookup("java:global/lol/DirectoryEntry!remake.DirectoryServerIF");

	    bean.addEntry("allo","morray");
	    bean.listAllEntries();


			
    } 
} 
