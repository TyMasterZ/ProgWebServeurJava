package serveur;

import services.*;
import servicesThread.ServiceFactory;

import java.io.IOException;
import bibliotheque.Bibliotheque;
public class Serveur implements Runnable {
	

	public static final int P_EMPRUNTER = 2600, P_RETOUR =2700, P_RESERVER = 2500;
	private ServiceServeur SSEmprunter,SSRetour,SSReserver;
	private Bibliotheque bibliotheque;
	
	public Serveur(Bibliotheque b) throws IOException{
		bibliotheque=b;
		IService factory = new ServiceFactory();
		SSEmprunter = new ServiceServeur(bibliotheque,P_EMPRUNTER);
		System.out.println("Service serveur Emprunter initialisé.");
		SSRetour = new ServiceServeur(bibliotheque,P_RETOUR);
		System.out.println("Service serveur Retour initialisé.");
		SSReserver =  new ServiceServeur(bibliotheque,P_RESERVER);
		System.out.println("Service serveur Reserver initialisé.");
		SSEmprunter.createFactory(factory);
		SSReserver.createFactory(factory);
		SSRetour.createFactory(factory);
		
	}


	@Override
	public void run() {
		SSEmprunter.lancer();
		System.out.println("Service serveur Emprunter lancé.");
		SSRetour.lancer();
		System.out.println("Service serveur Retour lancé.");
		SSReserver.lancer();
		System.out.println("Service serveur Reserver lancé.");
	}

	public void lancer(){
		new Thread(this).start();
	}
	
	
}
