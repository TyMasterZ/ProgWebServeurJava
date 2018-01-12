package bibliotheque;

import java.util.ArrayList;
import java.util.List;

public class Bibliotheque {
	public static List<Abonne> listAbo;
	public static List<Document> listDocument;
	
	
	public Bibliotheque(){
		this.listAbo=new ArrayList<>();	
		this.listDocument=new ArrayList<>();
	}
	
	public void ajouterDocument(Document d){
		this.listDocument.add(d);
	}
	
	public void ajouterAbo(Abonne a){
		this.listAbo.add(a);
	}
	
	public Document getDocument(int id){
		return this.listDocument.get(id);
	}
	
	public Abonne getAbo(int id){
		return this.listAbo.get(id);
	}
}
