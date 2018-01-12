package serveur;

import services.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import bibliotheque.Bibliotheque;
public class Serveur implements Runnable {
	

	public static final int P_EMPRUNTER = 2600, P_RETOUR =2700, P_RESERVER = 2500;
	private ServiceServeur SSEmprunter,SSRetour,SSReserver;
	private Bibliotheque bibliotheque;
	
	public Serveur(Bibliotheque b) throws IOException{
		bibliotheque=b;
		SSEmprunter = new ServiceServeur(bibliotheque,P_EMPRUNTER);
		System.out.println("Service serveur Emprunter initialis�.");
		SSRetour = new ServiceServeur(bibliotheque,P_RETOUR);
		System.out.println("Service serveur Retour initialis�.");
		SSReserver =  new ServiceServeur(bibliotheque,P_RESERVER);
		System.out.println("Service serveur Reserver initialis�.");
	}


	@Override
	public void run() {
		SSEmprunter.lancer();
		System.out.println("Service serveur Emprunter lanc�.");
		SSRetour.lancer();
		System.out.println("Service serveur Retour lanc�.");
		SSReserver.lancer();
		System.out.println("Service serveur Reserver lanc�.");
	}

	public void lancer(){
		new Thread(this).start();
	}
	
	
}
