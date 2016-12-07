import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.*;

@Stateless(name="annuaire")
public class DirectoryServer implements DirectoryServerIF {

    @PersistenceContext 
    private EntityManager em;
    
    public void listEntries(String nom){
	Query q = em.createQuery("select OBJECT(b) from DirectoryEntry b where b.nom = :"+nom);
	DirectoryEntry d = q.getResultList();
	for(int i = 0;i < d.getMails.size();i++){
	    System.out.println(d.getMails.get(i));
	}
	
    }

    public void listAllEntries(){
	Query q = em.createNamedQuery("alldir");
	List<DirectoryEntry> list = (List<DirectoryEntry>) q.getResultList(); 
	for(int i = 0;i < list.size();i++){
	    System.out.println(list.get(i).getNom());
	    list.get(i).afficherMail();
	}
    }

    public void addEntry(String nom,String mail){
	DirectoryEntry d = new DirectoryEntry(nom,mail);
	em.persist(d);
    }

    public void removeEntry(String nom, String mail){
        Query q = em.createQuery("select OBJECT(b) from DirectoryEntry b where b.nom = :"+nom);
	DirectoryEntry d = q.getResultList();
	d.supprimerMail(mail);
	em.persist(d);
    }

    public void removeEntries(String nom){
	Query q = em.createQuery("select OBJECT(b) from DirectoryEntry b where b.nom = :"+nom);
	DirectoryEntry d = q.getResultList();
	d.supprimerTousMail();
	em.persist(d);
    }
	
}
