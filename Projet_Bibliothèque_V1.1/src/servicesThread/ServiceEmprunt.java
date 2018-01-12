package servicesThread;

import java.io.IOException;
import java.net.Socket;

import bibliotheque.Bibliotheque;
import bibliotheque.Document;
import etatDocument.PasLibreException;
import services.Service;

public class ServiceEmprunt extends Service{

	
	public ServiceEmprunt(Socket s,Bibliotheque b) throws IOException {
		super(s,b);
	}
	
	public void lancer() {
		new Thread(this).start();
	}
	
	public void run(){
		int numAbo= readNumber();
		int numDoc = readNumber();
		
		Document document = bibliotheque.getDocument(numDoc);
		
		synchronized (document){
			try {
				document.emprunter(bibliotheque.getAbo(numAbo));
			} catch (PasLibreException e) {
				e.printStackTrace();
			}
		}
	}

}
