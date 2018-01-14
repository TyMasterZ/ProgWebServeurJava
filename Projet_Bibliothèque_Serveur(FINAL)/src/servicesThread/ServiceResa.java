package servicesThread;

import java.io.IOException;
import java.net.Socket;
import bibliotheque.Bibliotheque;
import bibliotheque.Document;
import etatDocument.PasLibreException;
import mail.Mail;
import services.Service;

public class ServiceResa extends Service {

	
	public ServiceResa(Socket s,Bibliotheque b) throws IOException {
		super(s,b);
	}
	
	
	public void lancer() {
		new Thread(this).start();
	}

	@Override
	public void run() {
		int numAbo= readNumber();
		int numDoc = readNumber();
		
		Document document = bibliotheque.getDocument(numDoc);
		
		if (bibliotheque.getAbo(numAbo).estInterdit()) {
			this.out.println("L'abonne num�ro : "+ numAbo + " est interdit d'emprunt jusqu'au : "+ dateFormat.format(bibliotheque.getAbo(numAbo).getCalendar()));
		}
		else {
			synchronized(document){
				try {
					document.reserver(bibliotheque.getAbo(numAbo));
					this.out.println("Le livre " + document.numero() + "a �t� r�serv� par l'abonn� numero : " + numAbo + ". Pensez � venir le r�cup�rer sous 2h.");
				} catch (PasLibreException e) {
					this.out.println(e.getMessage());
				
				}
			
				String adresseMail = null;
				try {
					adresseMail = in.readLine();
					if(adresseMail.equals("n")) {
						this.out.println("Aucune notification ne sera envoy�e.");
					}
					else {
						bibliotheque.addMail(new Mail(adresseMail,document));
						this.out.println("La demande de notification a l'adresse : "+ adresseMail + " a bien �t� enregistr�.");
					}
				} catch (IOException e) {e.printStackTrace();}
			
			
			
				System.out.println("Service Reservation termin�.");
			
				try {
					this.socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}