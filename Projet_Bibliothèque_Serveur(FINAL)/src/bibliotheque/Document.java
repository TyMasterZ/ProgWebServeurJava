package bibliotheque;

import exception.DejaDisponibleException;
import exception.PasLibreException;

public interface Document {
	int numero();
	void reserver(Abonne ab) throws PasLibreException ;
	void emprunter(Abonne ab) throws PasLibreException;
	void retour() throws DejaDisponibleException; // document rendu ou annulation réservation
}
