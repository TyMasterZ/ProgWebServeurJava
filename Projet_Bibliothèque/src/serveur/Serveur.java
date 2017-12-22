package serveur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur implements Runnable {
	
	private ServerSocket socketRetour;
	private ServerSocket socketEmprunt;
	private ServerSocket socketReservation;
	private int state=0;
	private int numLivre;
	private int numAbo;
	
	
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
				
				BufferedReader inRetour = new BufferedReader (new InputStreamReader(retour.getInputStream ( )));
				BufferedReader inEmprunt = new BufferedReader (new InputStreamReader(emprunt.getInputStream ( )));
				BufferedReader inReserv = new BufferedReader (new InputStreamReader(reserv.getInputStream ( )));
				
				String messageRetour = inRetour.readLine();
				String messageEmprunt = inEmprunt.readLine();
				String messageReserv = inReserv.readLine();
				
				if (messageRetour != null){
				numLivre = Integer.parseInt(messageRetour);
				state = 1;
				}
				else if (messageEmprunt!=null){
					int[] i= DecomposeString(messageEmprunt);
					numLivre=i[0];
					numAbo=i[1];
					state = 2;
				}
				else if (messageReserv != null){
					int[] i= DecomposeString(messageEmprunt);
					numLivre=i[0];
					numAbo=i[1];
					state = 3;
				}
				else {state = 0;}

				switch(state) {
				case 1 : new ServiceRetour(numLivre).lancer();
				case 2 : new ServiceEmprunt(numLivre,numAbo).lancer();
				case 3 : new ServiceResa(numLivre,numAbo).lancer();
				}
				
			} catch (IOException e) {
				System.err.println("probleme lors de l'ouverture de Socket." + e);
			}
		}
	}

		
		
	public int[] DecomposeString(String test){
		String chiffre ="";
		int pos = 0;
		int[] tab = new int[2];
			
		for(int i = 0; i < test.length(); i++){
			if( test.charAt(i) < 58 && test.charAt(i) > 47){
				System.out.println(test.charAt(i));
				chiffre += test.charAt(i);
				System.out.println(chiffre);
			}
			else if (test.charAt(i)== ',' || test.charAt(i) == ';' ){
				if(pos == 0){
					tab[pos++] = Integer.parseInt(chiffre);
					chiffre = "";
				}
			}
		}
		tab[1] = Integer.parseInt(chiffre);
		return tab;
	}
	
	
}
