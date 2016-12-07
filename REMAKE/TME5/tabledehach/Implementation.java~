package calculatrice;

public class Implementation extends calculatrice.OperationPOA{


    public float add (float op1, float op2){
	return op1+op2;
    }
    public float sub (float op1, float op2){
	return op1-op2;
    }
    public float mult (float op1, float op2){
	return op1*op2;
    }
    public float div (float op1, float op2) throws calculatrice.DivisionParZeroException{
	if(op2==0)
	    throw new calculatrice.DivisionParZeroException();
	return op1/op2;
    }
}
	
