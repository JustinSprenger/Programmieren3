package Uebung_6_2;

import java.net.*;
import java.io.*;


public class Client 
{
	
	
	
	// liest alle vom Server geschickten Daten
	  static void zeigeWasKommt(BufferedReader sin) throws IOException {
	    String str = null;
	    try {
	      while ((str = sin.readLine()) != null)
	        System.out.println(str);
	    } 
	    catch (SocketTimeoutException sto) {
	    }
	  }

	  static void zeigePrompt() {
	    System.out.print("> ");
	    System.out.flush();
	  }

	  public static void main(String[] args) {
	    try {
	      System.out.println("Client laeuft. Beenden mit QUIT");
	      Socket c = new Socket("localhost", Integer.parseInt("2222"));
	      c.setSoTimeout(500); // setze Timeout auf eine halbe Sekunde
	      BufferedReader vomServer = new BufferedReader(
	                                       new InputStreamReader(
	                                             c.getInputStream()));
	      PrintWriter zumServer = new PrintWriter(
	                                    c.getOutputStream(), true);
	      BufferedReader vonTastatur = new BufferedReader(
	                                         new InputStreamReader(
	                                               System.in));
	      String zeile;

	      do {
	        zeigeWasKommt(vomServer);
	        zeigePrompt();
	        zeile = vonTastatur.readLine();
	        zumServer.println(zeile);
	      } while(!zeile.equalsIgnoreCase("quit"));
	      
	      c.close();         // Socket (und damit auch Stroeme) schliessen
	    }
	    catch (ArrayIndexOutOfBoundsException ae) {
	      System.out.println("Aufruf: java MyClient <Port-Nummer>");
	    }
	    catch (UnknownHostException ux) {
	      System.out.println("Kein DNS-Eintrag fuer " + args[0]);
	    }
	    catch (IOException e) {
	      e.printStackTrace();
	    }
	  }


}
