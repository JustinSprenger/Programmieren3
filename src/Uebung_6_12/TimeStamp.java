package Uebung_6_12;

import java.io.*;
import java.net.*;
import java.util.*;
import java.text.*;

public class TimeStamp 
{
	static SimpleDateFormat timee = new SimpleDateFormat("'Es ist aktuell: 'H'.'mm' Uhr'");
	
	Socket sock;
	BufferedReader br;
	PrintWriter pr;
	
	public TimeStamp (Socket s)
	{
		try
		{
			this.sock = s;
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			pr = new PrintWriter(s.getOutputStream(),true);
			}
		catch (IOException e)
		{
			System.out.println("IO");
			e.printStackTrace();
		}	
	}
	public void transfer()
	{
		try
		{
			pr.println("time eingeben!");
			String eingabe = br.readLine();
			Date systemtime = new Date();
			
			if(eingabe.equalsIgnoreCase("time"))
			{
				pr.println(timee.format(systemtime));
			}
			else
			{
				pr.println(eingabe +" Fehler! ");
				sock.close();
			}
			
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}	
	}
}
