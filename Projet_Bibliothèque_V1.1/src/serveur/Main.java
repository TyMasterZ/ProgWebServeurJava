package serveur;

import bibliotheque.Bibliotheque;

public class Main {

	public static void main(String[] args) {
		try {
			Bibliotheque b = new Bibliotheque();
			Serveur serveur = new Serveur(b);
			serveur.lancer();
		}catch(Exception e) {e.printStackTrace();}
	}

}
