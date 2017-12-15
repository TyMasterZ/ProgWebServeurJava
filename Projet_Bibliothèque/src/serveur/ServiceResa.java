package serveur;

import biblioth�que.Abonne;
import biblioth�que.Biblioth�que;
import biblioth�que.Document;
import biblioth�que.PasLibreException;

public class ServiceResa implements Runnable {
	private int numDoc;
	private int numAbo;
	
	
	
	public void lancer() {
		new Thread(this).start();
	}

	@Override
	public void run() {
			for (Document d : Biblioth�que.listLivre){
				if(d.numero()==numDoc){
					for(Abonne a: Biblioth�que.listAbo){
						if (a.getnum()==numAbo){
							try {
								d.reserver(a);
							} catch (PasLibreException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
	}


