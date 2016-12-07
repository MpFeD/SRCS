package remake;

import javax.ejb.Remote;

@Remote
public interface DirectoryServerIF {

    public void listEntries(String nom);
     
    public void  listAllEntries();
  
    public void addEntry(String nom, String mail);
    
    public void removeEntry(String nom, String mail) throws DirectoryEntryException;

    public void removeEntries(String nom) throws DirectoryEntryException;

}
