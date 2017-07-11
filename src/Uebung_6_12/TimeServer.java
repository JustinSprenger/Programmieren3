package Uebung_6_12;

import java.io.*;
import java.net.*;


public class TimeServer {

	public static void main(String[] args) 
	{
		try
		{
			int port = Integer.parseInt("2222");//Portnummer
			
			ServerSocket server = new ServerSocket(port);//server socket
			System.out.println("Server sollte laufen");//Statusmeldung
			Socket s = server.accept();//Client verbindung akzeptieren
			new TimeProtokoll(s).transact();
		}
		catch(ArrayIndexOutOfBoundsException ae)
		{
			System.out.println("Aufruf: javaTimeServer <Port-Nr>");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		

	}

}
