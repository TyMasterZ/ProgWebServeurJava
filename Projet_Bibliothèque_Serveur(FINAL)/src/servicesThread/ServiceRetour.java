package servicesThread;

import java.io.IOException;
import java.net.Socket;


import bibliotheque.Bibliotheque;
import bibliotheque.Document;
import bibliotheque.Livre;
import services.Service;

public class ServiceRetour extends Service {

	
	public ServiceRetour(Socket s,Bibliotheque b) throws IOException{
		super(s,b);
	}
	
	public void lancer() {
		new Thread(this).start();
	}

	@Override
	public void run() {
		int numDoc = readNumber();
		int abime = readNumber();
		
		Document document = bibliotheque.getDocument(numDoc);
		
		synchronized(document){
			if (abime == 1) {
				Bibliotheque.interdictionAbonne((Livre) document);
			}
		document.retour();
		this.out.println("Le livre " + document.numero() + "a bien été retourné.");
		Bibliotheque.envoyerMail(document);
		
		}
		
		
		System.out.println("Service Retour terminé.");
		
		try {
			this.socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
