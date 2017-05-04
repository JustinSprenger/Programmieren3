package Uebung1;

import java.util.LinkedList;

import Uebung1.Enum.Verlag;

public class Buch implements Buchinfo{
	private int id;
	private String autor;
	private String titel;
	private String isbn;
	private int ejahr;
	private Enum.Verlag verlag;
	
	Buch(int bid,String bautor, String btitel, String bisbn,int bejahr, Enum.Verlag bverlag){
		this.id = bid;
		this.autor = bautor;
		this.titel = btitel;
		this.isbn = bisbn;
		this.ejahr = bejahr;
		this.verlag = bverlag;
	}
	// TODO Auto-generated method stub
	
	@Override
	public String showIDIsbn() {
		String result;
		result = "ID:  " + this.id + "ISBN:   " + this.isbn;
		return result;
	}

	@Override
	public String showIDAutor() {
		String result;
		result = "ID:  " + this.id + "Autor:   " + this.autor;
		return result;
	}

	@Override
	public String showIDTitel() {
		String result;
		result = "ID:  " + this.id + "Titel:   " + this.titel;
		return result;
	}

	@Override
	public String showAutorTitel() {
		String result;
		result = "Autor:  " + this.autor + "Titel:   " + this.titel;
		return result;
	}

	@Override
	public String showTitelJahr() {
		String result;
		result = "Titel:  " + this.titel + "Erscheinungsjahr:   " + this.ejahr;
		return result;
	}

	@Override
	public String showTitelVerlag() {
		String result;
		result = "Titel:  " + this.titel + "Verlag:   " + this.verlag;
		return result;
	}

	@Override
	public void editID(int bid) {
		this.id = bid;
	}

	@Override
	public void editISBN(String bisbn) {
		this.isbn = bisbn;
	}

	@Override
	public void editAutor(String bautor) {
		this.autor = bautor;
	}

	@Override
	public void editTitel(String btitel) {
		this.titel = btitel;
	}

	@Override
	public void editAutorTitel(String bautor, String btitel) {
		this.autor = bautor;
		this.titel = btitel;
	}

	@Override
	public void editJahr(int jahr) {
		this.ejahr = jahr;
	}

	@Override
	public void editVerlagTitel(Verlag bverlag, String btitel) {
		this.verlag = bverlag;
		this.titel = btitel;
	}

	@Override
	public void editVerlag(Verlag bverlag) {
		this.verlag = bverlag;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getEjahr() {
		return ejahr;
	}

	public void setEjahr(int ejahr) {
		this.ejahr = ejahr;
	}

	public Enum.Verlag getVerlag() {
		return verlag;
	}

	public void setVerlag(Enum.Verlag verlag) {
		this.verlag = verlag;
	}

	@Override
	public String toString() {
		return "Buch [ID= " + id + ", Autor= " + autor + ", Titel= " + titel + ", ISBN= " + isbn + ", Erscheinungsjahr= " + ejahr
				+ ", Verlag= " + verlag.getVerlagName() + "]";
	}
	
	public static void isFrom (int jahr,Buch[] b){
		for(int i=0;i<b.length;i++){
			if(b[i].getEjahr() == jahr){
				System.out.println(b[i].showAutorTitel());
			}
		}
	}
	
	public static int idsearch (int id,Buch[] b){
		int index = b.length;
		int erg=0;
		for(int i = 0;i<index;i++){
			if(id == b[i].getId()){
				erg = i;
			}
		}
		return erg;
	}

	@Override
	public String showBuch() {
		
		return null;
	}

	@Override
	public void removeBuch() {
		
		
	}
}
