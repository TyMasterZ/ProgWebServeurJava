package AppliClientParticulier;
import java.io.IOException;
import java.util.Scanner;


public class MainResa {

	public static void main(String[] args) throws IOException {
		Scanner sc;
		boolean quit = false;

		while (!quit) {
			System.out.println("1. Reserver un livre");
			System.out.println("2. Quitter");


			sc = new Scanner(System.in);

			AppliClient client = null;

			switch (sc.nextInt()) {

			case 1:
				try {
					client = new AppliResa();
				} catch (IOException e) {System.out.println("Connexion perdue");}
				break;

			case 2:
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


