package serveur;

import bibliothèque.Abonne;
import bibliothèque.Bibliothèque;
import bibliothèque.Document;

public class ServiceResa implements Runnable {
	private int numDoc;
	private int numAbo;
	
	
	
	public void lancer() {
		new Thread(this).start();
	}

	@Override
	public void run() {
			for (Document d : Bibliothèque.listLivre){
				if(d.numero()==numDoc){
					for(Abonne a: Bibliothèque.listAbo)
						if (a.)
						d.reserver(a);
				}
			}
	}

}
