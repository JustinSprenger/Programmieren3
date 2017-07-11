package Uebung_6_12;

import java.io.*;
import java.net.*;
import java.util.*;
import java.text.*;

public class TimeStamp 
{
	static SimpleDateFormat time = new SimpleDateFormat("Es ist aktuell: ");
	
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
			e.printStackTrace();
		}	
	}
	public void transfer()
	{
		try
		{
			pr.println("Enter drücken!");
			String eingabe = br.readLine();
			Date systemtime = new Date();
			pr.println(time.format(systemtime));
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}	
	}
}
