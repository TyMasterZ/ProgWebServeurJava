package serveur;

import biblioth�que.Abonne;
import biblioth�que.Biblioth�que;
import biblioth�que.Document;

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
					for(Abonne a: Biblioth�que.listAbo)
						if (a.)
						d.reserver(a);
				}
			}
	}

}
