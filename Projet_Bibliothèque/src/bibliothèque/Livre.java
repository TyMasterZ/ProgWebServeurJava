package bibliothèque;

import java.time.Clock;
import java.time.LocalTime;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


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
		long startTime = System.currentTimeMillis();
		long tempsPasse=0;
		while (tempsPasse<10000){
			if (statut!=1){
				break;
			}
			tempsPasse=(new Date()).getTime() - startTime;
		}
		if (statut == 1){
		retour();
		}
	}

	@Override
	public void emprunter(Abonne ab) throws PasLibreException {
		if (ab == this.abonne && statut == 1){
		this.statut=2;
		}
	}

	@Override
	public void retour() {
		if (this.statut !=0){
			this.abonne=null;
			this.statut=0;	
		}
	}
}
