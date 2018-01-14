package bibliotheque;

import bibliotheque.Abonne;
import bibliotheque.Document;
import exception.AbonneInconuException;
import exception.DejaDisponibleException;
import exception.PasLibreException;

public class Livre implements Document {
	private int numero;
	private Abonne abonne;
	private String etat;	
	private TimeLeft t;
	
	public Livre(int numéro){
		this.numero=numéro;
		this.etat ="Disponible";
		this.abonne= null;
	}

	@Override
	public int numero() {
		return numero;
	} 
	
	public void NoTimeLeft(Livre livre) throws DejaDisponibleException {
		livre.retour();
	}
	
	public Abonne getAbonne()throws AbonneInconuException {
		if (this.abonne == null) {
			throw new AbonneInconuException();
		}
		else return this.abonne;
	}
	
	public String getEtat() {
		return this.etat;
	}
	@Override
	public void reserver(Abonne ab) throws PasLibreException {
		if (this.etat == "Disponible"){
			this.etat = "Reserver";
			this.abonne = ab;
			t = new TimeLeft(this);
			System.out.println(this.etat + " "+ this.abonne);
			
			
		}
		else throw new PasLibreException();
	}

	@Override
	public void emprunter(Abonne ab) throws PasLibreException {
		if (this.etat == "Disponible"){
			this.etat = "Emprunter";
			this.abonne=ab;
			System.out.println(this.etat + " "+ this.abonne);
		}
		else if (this.etat=="Reserver"){
			
			if (this.abonne == ab){
				
				this.etat = "Emprunter";
				t.stopTimer();
				System.out.println(this.etat + " "+ this.abonne);
			}
			
			else {
				
				throw new PasLibreException();
			}
		}
		else throw new PasLibreException();
		
	}

	@Override
	public void retour() throws DejaDisponibleException {
		if (this.etat == "Disponible") {
			throw new DejaDisponibleException();
		}
		else {
			this.etat="Disponible";
			this.abonne=null;
			System.out.println(this.etat + " "+ this.abonne);
		}
	}
}
