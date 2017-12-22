package bibliothèque;

import java.util.ArrayList;

public class Abonne {
	private int num;
	private String nom;
	private ArrayList<Livre> livreEmprunte;
	
	public Abonne(int num,String nom){
		this.nom=nom;
		this.num=num;
		livreEmprunte=new ArrayList<Livre>();
	}
	
	public int getnum(){
		return this.num;
	}
}
