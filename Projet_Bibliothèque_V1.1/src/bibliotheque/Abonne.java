package bibliotheque;

import java.util.ArrayList;
import java.util.List;


public class Abonne {
	public static int nbAbo = 0;
	private int numAbo;

	public Abonne(){
		numAbo = nbAbo++;
	}
	
	public int getNumAbo(){
		return this.numAbo;
	}
	
}
