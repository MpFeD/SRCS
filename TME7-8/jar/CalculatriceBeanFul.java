import javax.ejb.Stateful;
import java.util.*;

@Stateful
public class CalculatriceBeanFul implements CalcItfFul {

    private ArrayList<Double> dernierResultat=new ArrayList<Double>();
    
    public double add(double d1, double d2){
	dernierResultat.add(d1+d2);
	return d1+d2;
    }

    public double sub(double d1, double d2){
	dernierResultat.add(d1-d2);
	return d1-d2;
    }

    public double mult(double d1, double d2){
	dernierResultat.add(d1*d2);
	return d1*d2;
    }

    public double div(double d1, double d2) throws DivByZeroException{
	if(d2==0)
	    throw new DivByZeroException();
	else{
	    dernierResultat.add(d1/d2);
	    return d1/d2;
	}
    }

    public double getDernierResultat(){
	return dernierResultat.get(0);
    }
}
