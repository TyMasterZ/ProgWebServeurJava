package exception;

@SuppressWarnings("serial")
public class AbonneInconuException extends Exception {
	public AbonneInconuException() {
		super("Le numero d'abonne n'existe pas.");
	}
}
