package exception;

@SuppressWarnings("serial")
public class DejaDisponibleException extends Exception {
	public DejaDisponibleException() {
		super("Le document demander est d�j� disponible.");
	}
}
