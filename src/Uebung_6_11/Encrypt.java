package Uebung_6_11;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Encrypt 
{
	public static void main(String[] args) throws IOException
	{
		byte[] key = "klar2.txt".getBytes();
		String inFile = "klar2.txt";
		String outFile = "klar3.txt";
		
		try (BufferedInputStream in = new BufferedInputStream(
				new FileInputStream(inFile));
				EncryptOutputStream out = new EncryptOutputStream(
						new BufferedOutputStream(new FileOutputStream(outFile)),key))
{
	int n;
	byte[] b = new byte[1024];
	while ((n= in.read(b)) != -1)
	{
		out.write(b, 0, n);
		
	}
}
	}

}
