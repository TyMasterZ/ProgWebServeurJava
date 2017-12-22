package serveur;

import biblioth�que.Abonne;
import biblioth�que.Biblioth�que;
import biblioth�que.Document;
import biblioth�que.PasLibreException;

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
		for (Document d : Biblioth�que.listLivre){
			if(d.numero()==numDoc){
				for(Abonne a: Biblioth�que.listAbo){
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
