package services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;

import bibliotheque.Bibliotheque;
import exception.DejaDisponibleException;

public abstract class Service implements Runnable{
	protected Socket socket;
	protected BufferedReader in;
	protected PrintWriter out;
	protected Bibliotheque bibliotheque;
	protected SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	
	public Service(Socket s,Bibliotheque b) throws IOException {
		this.socket=s;
		this.bibliotheque=b;
		this.in= new BufferedReader(new InputStreamReader(s.getInputStream()));
		this.out = new PrintWriter(s.getOutputStream(),true);
	}
	
	public void lancer(){
		new Thread(this).start();
	}
	
	public abstract void run();
	
	protected int readNumber() {
		int num = -1;
		
		try {
			String nombre = in.readLine();
			num = Integer.valueOf(nombre).intValue();
		}
		catch (NumberFormatException e) {System.out.println("Veuillez entrer un nombre !");} 
		catch (IOException e) {e.printStackTrace();;}
		
		return num;
	}
	
	public void finalize() throws Throwable {
		socket.close();
	}
}
