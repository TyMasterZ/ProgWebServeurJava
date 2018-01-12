package etatDocument;

public class PasLibreException extends Exception {
	public PasLibreException() {
		System.err.println("Le livre demander n'est pas disponible.");
	}
}
