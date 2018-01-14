package bibliotheque;

import java.util.Calendar;
import java.util.Date;

public class Abonne {
	public static int nbAbo = 0;
	private int numAbo;
	private static boolean interditEmprunt;
	private Calendar DureInterdiction;
	private Calendar compare; 
	public Abonne(){
		numAbo = nbAbo++;
		interditEmprunt = false;
		DureInterdiction=null;
	}
	
	public int getNumAbo(){
		return this.numAbo;
	}
	
	@SuppressWarnings("unused")
	public void setInterdiction() {
		interditEmprunt = true;
		DureInterdiction= Calendar.getInstance();
		if (Calendar.MONTH==Calendar.DECEMBER) {
			DureInterdiction.set(Calendar.MONTH, Calendar.JANUARY);
		}
		else DureInterdiction.add(Calendar.MONTH, 1);
	}
	
	public void autoriserEmprunt() {
		DureInterdiction = null;
		interditEmprunt=false;
	}
	
	public boolean estInterdit() {
		if (interditEmprunt) {
			compare=Calendar.getInstance();
			if (DureInterdiction.before(compare)) {
				autoriserEmprunt();
				return false;
			}
		}
		return interditEmprunt;
	}
	
	public Date getCalendar() {
		return DureInterdiction.getTime();
	}
	
}
