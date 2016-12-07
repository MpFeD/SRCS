package remake;

import javax.ejb.Stateless;

@Stateless
public class DirectoryEntry implements DirectoryServerIF {

    private String annuaire[][]  = new String[1000][1000];
    
    public void listEntries(String nom){
	for(int i=0;i<annuaire[0].length;i++){
	    if(annuaire[0][i].equals(nom)){
		for(int k=0;k<annuaire[i].length;k++){
		    System.out.println(annuaire[k][i]);
		}
	    }
	}
    }
	
    public void listAllEntries(){
	for(int i=0;i<annuaire[0].length;i++){
	    for(int j=0;j<annuaire[0].length;j++)
		System.out.println(annuaire[i][j] + " ");
	    System.out.println();
	}
    }
  
    public void addEntry(String nom, String mail){
	boolean trouve = false;
        for(int i=0;i<annuaire[0].length;i++){
	    if(annuaire[0][i].equals(nom)){
		trouve = true;
		int k=0;
		while (annuaire[i][k++] != "");
	        annuaire[i][k]=mail;
	    }
	}

	if(!trouve){
	    int k=0;
	    while (annuaire[0][k++] != "");
	    annuaire[0][k]=nom;
	    annuaire[1][k]=mail;
	}
    }
    
    public void removeEntry(String nom, String mail) throws DirectoryEntryException{}

    public void removeEntries(String nom) throws DirectoryEntryException{}
}
