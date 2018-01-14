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
		
		this.out.println(numLivre);
		
		String message = null;
		message = in.readLine();
		
		
		
		this.s.close();
		
	}

}
