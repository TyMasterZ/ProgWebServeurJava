package mail;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import bibliotheque.Document;

public class Mail{
	private Document doc;
	private String mail;
	
	

	public Mail(String email,Document doc) {
		this.doc=doc;
		this.mail=email;
	}
	
	public void exec() {
		
		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter("mail.txt",true));
			writer.write("@mail sent to "+mail+ " \n\nLe livre numéro : "+ doc.numero() + " que vous souhaitiez emprunter est désormais disponible !");
			writer.newLine();
			writer.close();
			System.out.println("mail sent");
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("c'est la");
		}
		
	}

	public Document getDocument() {
		return doc;
	}
	
}
