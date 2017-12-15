package serveur;

import bibliothèque.Bibliothèque;
import bibliothèque.Document;

public class ServiceRetour implements Runnable {
	private int num;
	
	public ServiceRetour(int num){
		this.num=num;
	}
	
	public void lancer() {
		new Thread(this).start();
	}

	@Override
	public void run() {
		for (Document d: Bibliothèque.listLivre){		
			if (d.numero()==this.num){
				d.retour();
			}
		}
	}

}
