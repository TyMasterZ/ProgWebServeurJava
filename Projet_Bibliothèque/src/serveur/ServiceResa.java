package serveur;

import java.time.Clock;
import java.time.ZoneId;

import bibliothèque.Abonne;
import bibliothèque.Bibliothèque;
import bibliothèque.Document;
import bibliothèque.PasLibreException;

public class ServiceResa implements Runnable {
	private int numDoc;
	private int numAbo;
	
	public ServiceResa(int livre,int abo) {
		this.numDoc=livre;
		this.numAbo=abo;
	}
	
	
	public void lancer() {
		new Thread(this).start();
	}

	@Override
	public void run() {
			for (Document d : Bibliothèque.listLivre){
				if(d.numero()==numDoc){
					for(Abonne a: Bibliothèque.listAbo){
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


