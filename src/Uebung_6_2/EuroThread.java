package Uebung_6_2;

	import java.io.*;
	import java.net.*;
	class EuroThread extends Thread {

		  Socket c;          // Socket für den Clients
		  BufferedReader in; // Eingabe-Strom zum Client
		  PrintWriter out;   // Ausgabe-Strom zum Client

		  // Einen Konstruktor für den EuroThread deklarieren
		  EuroThread(Socket sock) {
		    System.out.println("Neuer Client wird bearbeitet.");
		    // Den Client-Socket in der Instanzvariablen speichern
		    c = sock; 
		    // Try-Catch-Block beginnen
		    try {
		      // Den Eingabe-Strom zum Client erzeugen
		      in  = new BufferedReader(new InputStreamReader(c.getInputStream()));
		      // Den Ausgabe-Strom zum Client erzeugen
		      out = new PrintWriter(c.getOutputStream(), true);
		    } 
		    catch (IOException e) { }
		  }

		  public void run() {
		    try {
		      
		      String zeile;
		      double wert;
		      boolean toEuroDesired, nochmal;
		      
		      nochmal = true;
		      
		      // Protokoll für die Unterhaltung
		      
		      while (nochmal) {
		        out.println("Welche Waehrung wollen Sie eingeben (DM oder EUR)?");
		        zeile = in.readLine();
		        if (zeile == null) break;
		        toEuroDesired = zeile.toUpperCase().startsWith("DM");
		        
		        out.println("Welchen Wert wollen Sie umrechnen?");      
		        zeile = in.readLine();
		        if (zeile == null) break;
		        wert = Double.parseDouble(zeile);

		        if (toEuroDesired) {
		          wert = EuroConverter.convertToEuro (wert, EuroConverter.DEM);
		          out.println("Wert in EUR: " + wert);      
		        }
		        else {
		          wert = EuroConverter.convertFromEuro (wert, EuroConverter.DEM);
		          out.println("Wert in DM: " + wert);      
		        }
		        
		        out.println();      
		        out.println("Darf's noch eine Umrechnung sein?");      
		        zeile = in.readLine();
		        if (zeile == "Nein") break;
		        nochmal = zeile.startsWith("j") || zeile.startsWith("J");
		      }
		    } 
		    catch (IOException ign) { } 
		  }

}
