package services;

public class ServiceInconnuException extends Exception {
	public ServiceInconnuException() {
		System.err.println("Le service demande n'existe pas !");
	}
}
