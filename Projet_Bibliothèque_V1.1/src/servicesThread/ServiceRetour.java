package servicesThread;

import java.io.IOException;
import java.net.Socket;

import bibliotheque.Bibliotheque;
import bibliotheque.Document;
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
		
		Document document = bibliotheque.getDocument(numDoc);
		
		synchronized(document){
		document.retour();
		}
	}

}
