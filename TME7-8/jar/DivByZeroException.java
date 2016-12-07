
public class DivByZeroException extends Exception {

    public DivByZeroException (){
	super();
    }
    
    public void Affiche(){
	System.out.println("Division par zero detectee, Exception");
    }
}
