package Uebung_6_2;

import java.io.*;
import java.net.*;

public class Server 
{
	static boolean serverAktiv = true;
	  public static void main(String[] args) {
	    // Argumentanzahl �berpr�fen
	    if (args.length != 1) {
	      // Port-Nummer bestimmen
	      int port = Integer.parseInt("2222");
	      // Try-Catch-Block beginnen
	      try {
	        // Server-Steuerung aktivieren
	        new Steuerung().start();
	        // Einen Socket f�r den Server erzeugen
	        ServerSocket server = new ServerSocket(port);
	        System.out.println("Der Server laeuft.");
	        // "Endlos"-Schleife
	        while (serverAktiv) {
	          // F�r jeden Client, der eine Verbindung aufbaut,
	          // einen EuroThread starten
	          new EuroThread(server.accept()).start();
	        }
	      } 
	      catch (IOException e) {
	        e.printStackTrace();
	      }
	      System.out.println("Der Server ist beendet.");
	    }
	    else {
	      // Hinweis f�r korrekten Aufruf auf die Konsole ausgeben
	      System.out.println("Aufruf: java EuroServer <2222>");
	    }
	  }
	
}
