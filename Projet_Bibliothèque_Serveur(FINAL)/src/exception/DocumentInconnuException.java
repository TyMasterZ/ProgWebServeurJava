package exception;

@SuppressWarnings("serial")
public class DocumentInconnuException extends Exception {
	public DocumentInconnuException() {
		super("Le document demander n'existe pas.");
	}
}
