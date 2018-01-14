package AppliClientAcceuil;
import java.io.IOException;
import java.util.Scanner;


public class MainAcceuil {

	public static void main(String[] args) throws IOException {
		Scanner sc;
		boolean quit = false;

		while (!quit) {
			System.out.println("1. Emprunter un livre");
			System.out.println("2. Retourner un livre");
			System.out.println("3. Quitter");

			sc = new Scanner(System.in);

			AppliClient client = null;

			switch (sc.nextInt()) {

			case 1:
				try {
					client = new AppliEmprunt();
				} catch (IOException e) {System.out.println("Connexion perdue");}
				break;
			case 2:
				try {
					client = new AppliRetour();
				} catch (IOException e) {System.out.println("Connexion perdue");}
				break;
			case 3:
				quit = true;
				break;
			default:
				System.out.println("Veuillez entrer un chiffre entre 1 et 3");
				break;
			}
			if(client != null) client.task();
		}
	}
	
	
}


