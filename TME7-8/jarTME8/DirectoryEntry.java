import javax.persistence.*;
import java.util.*;
@Entity
public class DirectoryEntry {

    private String nom;
    private ArrayList <String> mail;

    public DirectoryEntry(){
	nom="";
	mail = new ArrayList<String>();
    }

    public DirectoryEntry(String nom,ArrayList<String> mail){
	this.nom=nom;
	this.mail=mail;
    }
    
    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    public String getNom() {
	return nom;
    } 
    public void setNom(String nom) {
	this.nom = nom;
    }
    public ArrayList<String> getMails(){
	return mail;
    }
    public void supprimerMail(String m){
        mail.remove(m);
    }
    public void supprimerTousMail(){
        mail.clear();
    }
    public void ajouterMail(String m){
        mail.add(m);
    }
    public void afficherMail(){
	for(int i=0;i<mail.size();i++)
	    System.out.println(mail.get(i));
    }
    
    
}


