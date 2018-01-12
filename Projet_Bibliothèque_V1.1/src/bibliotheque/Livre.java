package bibliotheque;




import bibliotheque.Abonne;
import bibliotheque.Document;
import etatDocument.*;

public class Livre implements Document {
	private int numero;
	private Abonne abonne;
	private String etat;
	
	
	public Livre(int numéro){
		this.numero=numéro;
		this.etat ="Disponible";
		this.abonne= null;
	}

	@Override
	public int numero() {
		return numero;
	} 

	@Override
	public void reserver(Abonne ab) throws PasLibreException {
		if (this.etat == "Disponible"){
			this.etat = "Reserver";
			this.abonne = ab;
		}
		else throw new PasLibreException();
	}

	@Override
	public void emprunter(Abonne ab) throws PasLibreException {
		if (this.etat == "Disponible"){
			this.etat = "Emprunter";
			this.abonne=ab;
		}
		else if (this.etat=="Reserver"){
			if (this.abonne == ab){
				this.etat = "Emprunter";
			}
		}
		else throw new PasLibreException();
	}

	@Override
	public void retour() {
		this.etat="Disponible";
		this.abonne=null;
	}
}
