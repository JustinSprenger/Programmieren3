package Uebung_6_12;

import java.io.*;
import java.net.*;


public class TimeServer {

	public static void main(String[] args) 
	{
		try
		{
			int port = Integer.parseInt("3000");
			
			ServerSocket server = new ServerSocket(port);
			System.out.println("Server gestartet");
			Socket s = server.accept();
			new TimeStamp(s).transfer();
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		

	}

}
