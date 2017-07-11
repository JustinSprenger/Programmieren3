package Uebung_6_2;

import java.io.*;
public class Steuerung extends Thread
{


	  BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	  String eingabe;
	  public void run() {
	    try {
	      // Solange Benutzer-Eingaben anfordern, bis SHUTDOWN eingegeben wird
	      do {
	        System.out.println("Server beenden durch Eingabe von SHUTDOWN!");
	      } while (!(eingabe = in.readLine()).toLowerCase().startsWith("shutdown"));
	      // EuroServer deaktivieren


	      Server.serverAktiv = false;
	      System.out.println("Der Server wird nun nach Abarbeitung des");
	      System.out.println("naechsten Clients automatisch beendet.");
	    } 
	    catch (IOException e) { }
	  }


	

}
