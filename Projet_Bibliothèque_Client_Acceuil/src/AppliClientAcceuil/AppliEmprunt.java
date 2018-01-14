package AppliClientAcceuil;
import java.io.IOException;


public class AppliEmprunt extends AppliClient {
	
	private static final int PORT = 2600;
	
	public AppliEmprunt() throws IOException {
		super(PORT);
	}

	@Override
	public void task() throws IOException {
		
		System.out.println("Entrez votre numéro d'abonné.");
		int numAbo = this.sc.nextInt();
		
		System.out.println("Entrez le numero du livre que vous souhaitez emprunter.");
		int numLivre = this.sc.nextInt();
		
		this.out.println(numAbo);
		this.out.println(numLivre);
		
		String message = null;
		message = in.readLine();
		
		if (message != null) {
			if (message.equals("Le livre demander n'est pas disponible.")) {
				System.out.println("1");
				System.out.print("Le livre demander n'est pas disponible...Si voulez vous recevoir une notification mail lorsqu'il sera de nouveau disponible entrer votre adresse mail ou entrer \"n\" si vous ne souhaiter pas etre notifié. ");
				System.out.println("2");
				String reponse = this.sc.next();
				System.out.println("3");
				this.out.println(reponse.toLowerCase());
				
				message = in.readLine();
				if (message != null) System.out.println(message);
			}
			else System.out.println(message);
		}
		
		this.s.close();
		
	}


	
	
}
