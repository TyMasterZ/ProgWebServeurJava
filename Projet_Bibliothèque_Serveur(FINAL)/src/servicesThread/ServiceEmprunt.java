package servicesThread;

import java.io.IOException;
import java.net.Socket;

import bibliotheque.Bibliotheque;
import bibliotheque.Document;
import exception.AbonneInconuException;
import exception.DocumentInconnuException;
import exception.PasLibreException;
import mail.Mail;
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
			
		Document document;
		
			
		
		
		try {
			document = bibliotheque.getDocument(numDoc);
			if (bibliotheque.getAbo(numAbo).estInterdit()) {
				this.out.println("L'abonne numéro : "+ numAbo + " est interdit d'emprunt jusqu'au : "+ dateFormat.format(bibliotheque.getAbo(numAbo).getCalendar()));
			}
			else {
				synchronized (document){
					try {
						document.emprunter(bibliotheque.getAbo(numAbo));
						this.out.println("Le livre " + document.numero() + " a bien été emprunté par l'abonné numéro : " + numAbo );
					} catch (PasLibreException e) {
						this.out.println(e.getMessage());
					} catch (AbonneInconuException e) {
						e.printStackTrace();
					}
					
					
					String adresseMail = null;
					try {
						adresseMail = in.readLine();
						if(adresseMail.equals("n")) {
							this.out.println("Aucune notification ne sera envoyée.");
						}
						else {
							bibliotheque.addMail(new Mail(adresseMail,document));
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
		} catch (AbonneInconuException e) {
			this.out.println(e.getMessage());
		} catch (DocumentInconnuException e1) {
			this.out.println(e1.getMessage());
		}
	}
}