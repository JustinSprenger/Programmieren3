package Uebung_6_12;

import java.net.*;
import java.io.*;

public class TimeClient
{
	public static void main(String[] args)
	{
		String hostName = "";
		int port;
		Socket c = null;
		
		try
		{
			hostName="localhost"; // bitte nur localhost
			port = Integer.parseInt("2222");
			c = new Socket(hostName, port);
			
			BufferedReader vomServer = new BufferedReader(
					new InputStreamReader(
							c.getInputStream()));
			PrintWriter zumServer = new PrintWriter(
					c.getOutputStream(),true);
			BufferedReader vonKeyboard = new BufferedReader(
					new InputStreamReader(System.in));
			
			//Protokoll abwickeln
			
			System.out.println("F*ckers der F*cking " + hostName +":"+port+" sagt dir die Zeit du Ficker");
			String text = vomServer.readLine();// vom server empfangen
			System.out.println(text);// auf konsole schreiben
			text = vonKeyboard.readLine();//von tastatur lesen
			zumServer.println(text);//zum server schicken
			text = vomServer.readLine();//vom server empfangen
			System.out.println(text);//auf konsole schreiben
			
			c.close();
			
			
			
		}
		catch(ArrayIndexOutOfBoundsException ae)
		{
			System.out.println("Aufruf:");
			System.out.println("java TimeVlient <F*cker> <2222>");
		}
		catch(UnknownHostException ue)
		{
			System.out.println("kein DNS Eintrag für "+ hostName);
		}
		catch(IOException e)
		{
			System.out.println("IO-Error");
		}
	}

}
