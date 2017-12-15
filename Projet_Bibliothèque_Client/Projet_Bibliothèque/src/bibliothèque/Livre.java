package bibliothèque;

public class Livre implements Document {
	private int numero;
	private int statut;
	private Abonne abonne;
	
	public Livre(int numéro){
		this.numero=numéro;
		this.statut=0;
		this.abonne= null;
	}
	

	@Override
	public int numero() {
		return numero;
	}

	@Override
	public void reserver(Abonne ab) throws PasLibreException {
		this.abonne=ab;
		this.statut=1;
	}

	@Override
	public void emprunter(Abonne ab) throws PasLibreException {
		this.abonne=ab;
		this.statut=2;
	}

	@Override
	public void retour() {
		if (this.statut !=0){
			this.abonne=null;
			this.statut=0;	
		}
	}
	
	
}
