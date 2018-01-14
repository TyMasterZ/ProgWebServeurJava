package serveur;

import bibliotheque.Abonne;
import bibliotheque.Bibliotheque;
import bibliotheque.Livre;

public class MainServeur {

	public static void main(String[] args) {
		try {
			Bibliotheque b = new Bibliotheque();
			for (int i=0;i<20;i++) {
				b.ajouterAbo(new Abonne());
			}
			
			for (int j=0;j<50;j++) {
				b.ajouterDocument(new Livre(j));
			}
			Serveur serveur = new Serveur(b);
			serveur.lancer();
		}catch(Exception e) {e.printStackTrace();}
	}

}
