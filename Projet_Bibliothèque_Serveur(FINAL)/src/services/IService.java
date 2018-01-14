package services;

import java.io.IOException;
import java.net.Socket;

import bibliotheque.Bibliotheque;


public interface IService {
	public Service createService(Socket s, Bibliotheque biblio) throws ServiceInconnuException, IOException;

}
