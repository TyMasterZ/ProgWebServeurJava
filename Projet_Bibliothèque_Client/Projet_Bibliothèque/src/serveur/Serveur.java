package serveur;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur implements Runnable {
	
	private ServerSocket socketRetour;
	private ServerSocket socketEmprunt;
	private ServerSocket socketReservation;
	private int state=0;
	
	
	public Serveur(){
		try {
			socketRetour = new ServerSocket(2700);
			socketEmprunt=new ServerSocket(2600);
			socketReservation=new ServerSocket(2500);
			System.out.println("Serveurs créés.");
			
		} catch (IOException e) {
			try {
				this.socketRetour.close();
				this.socketEmprunt.close();
				this.socketReservation.close();
			
			} catch (IOException e1) {}
			System.err.println("probleme lors de la création du serveur." + e);
		}
	}


	@Override
	public void run() {
		while (true){
			try {
				Socket retour=socketRetour.accept();
				Socket emprunt=socketEmprunt.accept();
				Socket reserv=socketReservation.accept();
				switch(state) {
				case 1 : new ServiceRetour().lancer();
				case 2 : new ServiceEmprunt().lancer();
				case 3 : new ServiceResa().lancer();
				}
				
			} catch (IOException e) {
				System.err.println("probleme lors de l'ouverture de Socket." + e);
			}
		}
	}
	
	
}
