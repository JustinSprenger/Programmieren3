package Uebung_6_11;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class Decrypt 
{
	public static void main(String[] args) throws IOException
	{
		
		
		byte[] key = "key.txt".getBytes();
		String inFile = "klar.txt";
		String outFile = "coded.txt";
		
		try(DecryptInputStream in = new DecryptInputStream(new BufferedInputStream(new FileInputStream(inFile)),key);
				
		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(outFile)))
		{
			int n;
			byte[] b = new byte [1024];
			while ((n= in.read(b)) != -1)
			{
				out.write(b, 0, n);
			}
			
		}
	}

}
