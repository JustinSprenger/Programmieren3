package Uebung_6_12;

import java.io.*;
import java.net.*;
import java.util.*;
import java.text.*;

public class TimeProtokoll 
{
	static SimpleDateFormat time = new SimpleDateFormat("'Es ist grade 'H'.'mm' Uhr'"); //Format f�r zeit
	
	Socket s;//Socket f�r verbindung mit clinet
	BufferedReader vomClient;//Eigabe strom vom client
	PrintWriter zumClient;//ausgabe strom zum client
	
	public TimeProtokoll (Socket s)//erzeugt ein und ausgabe str�me zum lesen gschickter informationen verwendung von buffered reader 
	{
		try
		{
			this.s = s;
			vomClient = new BufferedReader(
					new InputStreamReader(
							s.getInputStream()));
			zumClient = new PrintWriter(
					s.getOutputStream(),true);//mitteilung von server aktivierung des automatischen flushings f�r println aufrufe aktiviert
			}
		catch (IOException e)
		{
			System.out.println("IO-Error");
			e.printStackTrace();
		}
		
	}
	public void transact() // wenn time eingegeben wird wird date objekt erzeugt welches zeitformat ausgibt
	{
		System.out.println("Protokoll gestartet");
		try
		{
			zumClient.println("Geben sie Bitte'TIME' ein");
			String eingabe = vomClient.readLine();// vom client empfangen
			Date jetzt = new Date();//zeitpunkt bestimmen
			
			//eingabe
			
			if(eingabe.equalsIgnoreCase("time"))
			{
				zumClient.println(time.format(jetzt));
			}
			else
			{
				zumClient.println(eingabe +" als Kommando unzul�ssig!");
				s.close();//socket und auch str�me schlie�en
			}
		}
			catch(IOException e)
			{
				System.out.println("IO-Error");
			}
		System.out.println("Protokoll beendet");
		
	}
	

}
