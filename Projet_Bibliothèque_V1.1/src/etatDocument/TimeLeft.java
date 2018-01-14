package etatDocument;

import java.util.Timer;
import java.util.TimerTask;
import bibliotheque.Livre;

public class TimeLeft  {
	private Timer time;
	private Livre livre;
	
	public TimeLeft(Livre livre) {
		this.time=new Timer();
		this.livre=livre;
		this.time.schedule(new AnnulerReservation(livre), 2*60*60*1000);
	}
	
	public void stopTimer() {
		this.time.cancel();
	}

	private class AnnulerReservation extends TimerTask{

		private Livre livre;
		
		public AnnulerReservation(Livre livre) {
			this.livre = livre;
		}
		
		@Override
		public void run() {
			livre.NoTimeLeft(livre);
			System.out.println("Le delai de reservation est depasse.");
			System.out.println("Le document " + livre.numero() + " est de nouveau disponible.");
		}
	}

	

}
