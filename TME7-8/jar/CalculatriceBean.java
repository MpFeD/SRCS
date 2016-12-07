import javax.ejb.Stateless;

@Stateless
public class CalculatriceBean implements CalcItf {

    public double add(double d1, double d2){
	return d1+d2;
    }

    public double sub(double d1, double d2){
	return d1-d2;
    }

    public double mult(double d1, double d2){
	return d1*d2;
    }

    public double div(double d1, double d2) throws DivByZeroException{
	if(d2==0)
	    throw new DivByZeroException();
	else
	    return d1/d2;
    }
}
