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
			Inet4Address host = null;
			hostName=host.getLocalHost().getHostAddress();
			hostName = "localhost";
			port = Integer.parseInt("2222");
			c = new Socket(hostName, port);
			
			BufferedReader Serverread = new BufferedReader(new InputStreamReader(c.getInputStream()));
			PrintWriter Serverwrite = new PrintWriter(c.getOutputStream(),true);
			BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
						
			System.out.println("Host: " + hostName +":"+port);
			String text = Serverread.readLine();
			System.out.println(text);
			text = scan.readLine();
			Serverwrite.println(text);
			text = Serverread.readLine();
			System.out.println(text);
			
			c.close();
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			e.printStackTrace();
			System.out.println("Error1");
		}
		catch(UnknownHostException e)
		{
			e.printStackTrace();
			System.out.println("Error2");
		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.out.println("Error3");
		}
	}

}
