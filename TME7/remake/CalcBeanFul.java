package remake;

import javax.ejb.Stateful; 
@Stateful
public class CalcBeanFul implements CalcItfFul {

    private Double dernierResultat=new Double(0);
    
    public double add(double v1,double v2) {
	dernierResultat=v1+v2;
	return v1+v2;} 
    public double sub(double v1,double v2) {
	dernierResultat=v1+v2;
	return v1-v2;} 
    public double mult(double v1,double v2) {
	dernierResultat=v1*v2;
	return v1*v2;} 
    public double div(double v1,double v2)  throws DivByZeroException{
	if(v2 == 0)
	    throw new DivByZeroException();

	dernierResultat=v1/v2;
	return v1/v2;
    }
    
    public double getDernierResultat(){
	return dernierResultat;
    }
    
} 
