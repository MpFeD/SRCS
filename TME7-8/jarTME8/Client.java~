import javax.naming.*;
import java.util.*;


public class Client { 
    public static void main(String args[]) throws Exception {

	Hashtable<String,String> env = new Hashtable<String,String>();
	env.put(Context.PROVIDER_URL, "127.0.0.1:PORTNUMBER");	

	
	javax.naming.Context ic = new javax.naming.InitialContext(env);


	try{
	    //Stateless :
	    //CalcItf bean = (CalcItf) ic.lookup("java:global/calculatrice/CalculatriceBean!CalcItf");
	    //Stateful :
	    CalcItfFul bean = (CalcItfFul) ic.lookup("java:global/calculatrice/CalculatriceBeanFul!CalcItfFul");
	    double res = bean.div(1,1);
	    res = bean.add(3,3);
	    System.out.println("Le resultat de 3 + 3 est : " + res);
	    res = bean.add(bean.getDernierResultat(),3);
	    System.out.println("Le resultat de 3 + dernier resultat est : " + res);
	}catch (DivByZeroException e){
	    e.Affiche();
	}	
    } 
} 
