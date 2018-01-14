package etatDocument;

public class PasLibreException extends Exception {
	public PasLibreException() {
		super("Le livre demander n'est pas disponible.");
	}
}
