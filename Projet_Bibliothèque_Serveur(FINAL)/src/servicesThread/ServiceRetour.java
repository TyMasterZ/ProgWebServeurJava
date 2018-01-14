package servicesThread;

import java.io.IOException;
import java.net.Socket;


import bibliotheque.Bibliotheque;
import bibliotheque.Document;
import bibliotheque.Livre;
import exception.DejaDisponibleException;
import exception.DocumentInconnuException;
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
		
		Document document;
		try {
			document = bibliotheque.getDocument(numDoc);
			synchronized(document){
				try{											
					if (abime == 1) {
						Bibliotheque.interdictionAbonne((Livre) document);
					}
					document.retour();
					this.out.println("Le livre " + document.numero() + "a bien �t� retourn�.");
					Bibliotheque.envoyerMail(document);	
				}
				catch(DejaDisponibleException e) {
					this.out.println(e.getMessage());
				}
			}
		}
		catch (DocumentInconnuException e1) {
			this.out.println(e1.getMessage());
		}
		
		
		
		
		System.out.println("Service Retour termin�.");
		
		try {
			this.socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
