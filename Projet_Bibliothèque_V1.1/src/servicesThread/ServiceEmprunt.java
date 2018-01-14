package servicesThread;

import java.io.IOException;
import java.net.Socket;

import bibliotheque.Bibliotheque;
import bibliotheque.Document;
import etatDocument.PasLibreException;
import mail.ServiceMail;
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
				this.out.println("Le livre " + document.numero() + " a bien été emprunté par l'abonné numéro : " + numAbo );
			} catch (PasLibreException e) {
				this.out.println(e.getMessage());
			}
			

			String adresseMail = null;
			try {
				adresseMail = in.readLine();
				if(adresseMail != "n") {
					new ServiceMail(adresseMail,document).lancer();
					this.out.println("La demande de notification a l'adresse : "+ adresseMail + " a bien été enregistré.");
				}
			} catch (IOException e) {e.printStackTrace();}
			
			System.out.println("Service Emprunt terminé.");
			
			try {
				this.socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
