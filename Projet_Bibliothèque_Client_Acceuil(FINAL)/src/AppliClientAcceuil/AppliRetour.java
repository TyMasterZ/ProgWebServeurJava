package AppliClientAcceuil;
import java.io.IOException;



public class AppliRetour extends AppliClient {
	
	private static final int PORT = 2700;
	
	public AppliRetour() throws IOException {
		super(PORT);
	}

	@Override
	public void task() throws IOException {
		
		System.out.println("Entrez le numero du livre que vous souhaitez retourner.");
		int numLivre = this.sc.nextInt();
		System.out.println("Le livre est-il abimé ?  1.Oui ||  2.Non");
		int abime =this.sc.nextInt();
		
		this.out.println(numLivre);
		this.out.println(abime);
		
		String message = null;
		message = in.readLine();
		System.out.println(message);
		
		
		this.s.close();
		
	}

}
