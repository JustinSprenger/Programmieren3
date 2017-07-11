package Uebung_6_11;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class EncryptOutputStream extends FilterOutputStream
{
	private byte[] key;
	private int pos;

	public EncryptOutputStream(OutputStream out, byte[] key) {
		super(out);
		this.key=key;
		// TODO Auto-generated constructor stub
	}
	
	public void write(byte[] b, int offset, int count) throws IOException
	{
		for (int i = 0;i<count;i++)
		{
			super.write(b[offset + i] ^ next());
		}
	}
	
	public void write(byte[] b) throws IOException
	{
		write(b, 0, b.length);
	}
	
	private int next()
	{
		return key[pos++ % key.length];
	}

}
