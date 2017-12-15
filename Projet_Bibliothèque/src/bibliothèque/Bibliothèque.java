package bibliothèque;

import java.util.ArrayList;

public class Bibliothèque {
	public static ArrayList<Abonne> listAbo;
	public static ArrayList<Document> listLivre;
	
	
	public Bibliothèque(){
		this.listAbo=new ArrayList<Abonne>();	
		this.listLivre=new ArrayList<Document>();
	}
	
}
