package AppliClientParticulier;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public abstract class AppliClient {
	
	protected final Socket s;
	protected final BufferedReader in;
	protected final PrintWriter out;
	protected final Scanner sc ;
	

	public AppliClient(int port) throws IOException {
		s = new Socket("localhost", port);
		in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		out = new PrintWriter(s.getOutputStream(), true);
		sc = new Scanner(System.in);
	}

	public abstract void task() throws IOException;

}