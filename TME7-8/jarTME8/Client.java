import javax.naming.*;
import java.util.*;


public class Client { 
    public static void main(String args[]) throws Exception {

	Hashtable<String,String> env = new Hashtable<String,String>();
	env.put(Context.PROVIDER_URL, "127.0.0.1:PORTNUMBER");	

	
	javax.naming.Context ic = new javax.naming.InitialContext(env);


	DirectoryEntry bean = (DirectoryEntry) ic.lookup("java:global/calculatrice/DirectoryServerIF!DirectoryEntry");
        bean.addEntry("allo","wesh");
	bean.listAllEntries();
    } 
} 
