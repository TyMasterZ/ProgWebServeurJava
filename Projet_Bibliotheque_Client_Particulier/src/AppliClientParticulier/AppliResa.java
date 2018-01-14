package AppliClientParticulier;

import java.io.IOException;

public class AppliResa extends AppliClient {

	private static final int PORT = 2500;
	
	public AppliResa() throws IOException {
		super(PORT);
	}

	@Override
	public void task() throws IOException {
		System.out.println("Entrez votre numéro d'abonné.");
		int numAbo = this.sc.nextInt();
		
		System.out.println("Entrez le numero du livre que vous souhaitez reserver.");
		int numLivre = this.sc.nextInt();
		
		this.out.println(numAbo);
		this.out.println(numLivre);
		
		String message = null;
		message = in.readLine();
		
		if (message != null) {
			if (message.equals("Le livre demander n'est pas disponible.")) {
				System.out.println("Le livre demander n'est pas disponible.\n"
						+ "Si voulez vous recevoir une notification mail lorsqu'il sera de nouveau disponible \n"
						+ "entrer votre adresse mail ou entrer \"n\" si vous ne souhaiter pas etre notifié. ");
				String reponse = this.sc.nextLine();
				this.out.println(reponse.toLowerCase());
				
				message = in.readLine();
				if (message != null) System.out.println(message);
			}
			System.out.println(message);
		}
		
		this.s.close();
	}

}
