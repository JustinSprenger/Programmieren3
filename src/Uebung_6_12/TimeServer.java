package Uebung_6_12;

import java.io.*;
import java.net.*;


public class TimeServer {

	public static void main(String[] args) 
	{
		int port = Integer.parseInt("2222");
		System.out.println("Server gestartet");	
		ServerSocket server = null;
		try {
			server = new ServerSocket(port);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		while(true){
		try
		{	
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

}
