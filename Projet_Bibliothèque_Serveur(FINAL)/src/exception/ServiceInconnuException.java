package exception;

@SuppressWarnings("serial")
public class ServiceInconnuException extends Exception {
	public ServiceInconnuException() {
		super("Le service demande n'existe pas !");
	}
}
