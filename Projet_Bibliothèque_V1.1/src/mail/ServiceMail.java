package mail;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import bibliotheque.Document;

public class ServiceMail implements Runnable{
	private Document doc;
	private String mail;
	

	public ServiceMail(String email,Document doc) {
		this.doc=doc;
		this.mail=email;
	}
	
	@Override
	public void run() {
		try {
			synchronized (doc) {
				
				wait();
			
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File("mail")));
			
			writer.write("@mail sent to "+mail+ " \n\nLe livre numéro : "+ doc.numero() + " que vous souhaitiez emprunter est désormais disponible !");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void lancer() {
		new Thread(this).start();
	}

}
