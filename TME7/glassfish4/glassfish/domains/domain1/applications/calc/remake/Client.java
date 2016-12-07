package remake;
import java.util.*;
import javax.naming.*;

public class Client { 
    public static void main(String args[]) throws Exception {
	Hashtable<String,String> env = new Hashtable<String,String>();
	env.put(Context.PROVIDER_URL, "127.0.0.1:PORTNUMBER");	

	
	javax.naming.Context ic	= new javax.naming.InitialContext(env); 
	CalcItf bean = (CalcItf)ic.lookup("java:global/calc/CalcBean!remake.CalcItf"); 
	double res = bean.add(3,6);
	System.out.println(res);

	try{
	    res = bean.div(1,0);
	}catch (DivByZeroException e){
	    
	}


	CalcItfFul beanFul = (CalcItfFul)ic.lookup("java:global/calc/CalcBeanFul!remake.CalcItfFul"); 

	res = beanFul.add(1,1);
	res = beanFul.add(beanFul.getDernierResultat(),1);
	System.out.println(res);
    } 
} 
