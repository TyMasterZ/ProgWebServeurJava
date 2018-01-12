package servicesThread;

import java.io.IOException;
import java.net.Socket;

import bibliotheque.Bibliotheque;
import services.IService;
import services.Service;
import services.ServiceInconnuException;



public class ServiceFactory implements IService{
	
	private	 static final int P_RESERVER = 2500,	P_EMPRUNTER = 2600, P_RETOURNER = 2700;
	
	public Service createService(Socket s, Bibliotheque biblio) throws ServiceInconnuException, IOException {
		System.out.println("Tentative de creation d'un service sur le port " + s.getLocalPort());
		switch(s.getLocalPort()) {
		case P_EMPRUNTER:
			return new ServiceEmprunt(s, biblio);
		case P_RESERVER :
			return new ServiceResa(s, biblio);
		case P_RETOURNER :
			return new ServiceRetour(s, biblio);
		default:
			throw new ServiceInconnuException();
		}
	}
}
