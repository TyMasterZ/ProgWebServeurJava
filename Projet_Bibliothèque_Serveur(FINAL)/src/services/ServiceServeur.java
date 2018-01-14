package services;

import java.io.IOException;
import java.net.ServerSocket;

import bibliotheque.Bibliotheque;

public class ServiceServeur implements Runnable{
	
	private Bibliotheque bibliothque;
	private ServerSocket serveur;
	private IService serviceFactory;

	public ServiceServeur(Bibliotheque bibliotheque, int port) throws IOException {
		this.bibliothque=bibliotheque;
		this.serveur =  new ServerSocket(port);
	}
	
	public void lancer(){
		new Thread(this).start();
	}
	
	public void run(){
		while(true) {
			try {
				Service service = serviceFactory.createService(serveur.accept(), bibliothque);
				System.out.println("Service cree");
				service.lancer();
			} catch (ServiceInconnuException | IOException e) {e.printStackTrace();}
		}
	}
	
	public void createFactory(IService factory) {
		this.serviceFactory = factory;
	}
	
}
