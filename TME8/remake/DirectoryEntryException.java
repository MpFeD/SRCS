package remake;
public class DirectoryEntryException extends Exception {

    public DirectoryEntryException(){
	super();
    }
    
    public void Affiche(){
	System.out.println("Nom incorrect");
    }
}
