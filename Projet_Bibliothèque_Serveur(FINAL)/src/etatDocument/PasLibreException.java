package etatDocument;

@SuppressWarnings("serial")
public class PasLibreException extends Exception {
	public PasLibreException() {
		super("Le livre demander n'est pas disponible.");
	}
}
