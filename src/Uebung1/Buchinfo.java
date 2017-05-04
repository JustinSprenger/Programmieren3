package Uebung1;

public interface Buchinfo {
	 String showIDIsbn();
	 String showIDAutor();
	 String showIDTitel();
	 String showAutorTitel();
	 String showTitelJahr();
	 String showTitelVerlag();
	 String showBuch();
	 void editID(int bid);
	 void editISBN(String bisbn);
	 void editAutor(String bautor);
	 void editTitel(String btitel);
	 void editAutorTitel(String bautor, String btitel);
	 void editJahr(int jahr);
	 void editVerlagTitel(Enum.Verlag bverlag,String btitel);
	 void editVerlag(Enum.Verlag bverlag);
	 void removeBuch();
	 static void isFrom(int jahr,Buch[] b) {}
	 static Buch[] idsearch (int id,Buch[] b){
		return b;}
}
