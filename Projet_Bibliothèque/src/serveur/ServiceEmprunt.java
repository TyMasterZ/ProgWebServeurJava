package serveur;

import bibliothèque.Abonne;
import bibliothèque.Bibliothèque;
import bibliothèque.Document;
import bibliothèque.PasLibreException;

public class ServiceEmprunt implements Runnable{
	private int numDoc;
	private int numAbo;
	
	public ServiceEmprunt(int doc,int abo) {
		this.numDoc=doc;
		this.numAbo=abo;
	}
	
	public void lancer() {
		new Thread(this).start();
	}
	
	public void run(){
		for (Document d : Bibliothèque.listLivre){
			if(d.numero()==numDoc){
				for(Abonne a: Bibliothèque.listAbo){
					if (a.getnum()==numAbo){
						try {
							d.emprunter(a);
						} catch (PasLibreException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

}
