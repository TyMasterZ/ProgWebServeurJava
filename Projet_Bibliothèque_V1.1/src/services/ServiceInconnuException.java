package services;

public class ServiceInconnuException extends Exception {
	public ServiceInconnuException() {
		super("Le service demande n'existe pas !");
	}
}
