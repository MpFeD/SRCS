package remake;

import javax.ejb.Stateless; 
@Stateless
public class CalcBean implements CalcItf { 
    public double add(double v1,double v2) {return v1+v2;} 
    public double sub(double v1,double v2) {return v1-v2;} 
    public double mult(double v1,double v2) {return v1*v2;} 
    public double div(double v1,double v2)  throws DivByZeroException{
	if(v2 == 0)
	    throw new DivByZeroException();

	return v1/v2;

    } 
} 
