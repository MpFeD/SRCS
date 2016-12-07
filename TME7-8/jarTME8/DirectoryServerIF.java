import javax.ejb.Stateless;

@Stateless(name="annuaire")
public interface DirectoryServerIF {
    
    public void listEntries(String nom);

    public void listAllEntries();

    public void addEntry(String nom,String mail);

    public void removeEntry(String nom, String mail);

    public void removeEntries(String nom);
	
}
