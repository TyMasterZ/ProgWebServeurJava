package bibliotheque;

import java.util.ArrayList;
import mail.Mail;
import java.util.List;

public class Bibliotheque {
	private  List<Abonne> listAbo;
	private List<Document> listDocument;
	private static  List<Mail> listMail;
	
	
	public Bibliotheque(){
		this.listAbo=new ArrayList<>();	
		this.listDocument=new ArrayList<>();
		Bibliotheque.listMail=new ArrayList<>();
	}
	
	public void ajouterDocument(Document d){
		this.listDocument.add(d);
	}
	
	public void ajouterAbo(Abonne a){
		this.listAbo.add(a);
	}
	
	public void addMail(Mail m) {
		Bibliotheque.listMail.add(m);
	}
	
	public static void envoyerMail(Document d) {
		List<Mail>rem = new ArrayList<>();
		for (Mail m : listMail) {
			if (m.getDocument() == d) {
				m.exec();
				rem.add(m);
			}
		}
		for(Mail m : rem) {
			listMail.remove(m);
		}
	}
	
	public Document getDocument(int id){
		return this.listDocument.get(id);
	}
	
	public Abonne getAbo(int id){
		return this.listAbo.get(id);
	}
	
	public static void interdictionAbonne(Livre l) {
		l.getAbonne().setInterdiction();
	}
}
