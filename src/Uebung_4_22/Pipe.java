package Uebung_4_22;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Pipe {
	private DataOutputStream out;
	private DataInputStream in;
	
	public Pipe() throws IOException{
		PipedOutputStream src = new PipedOutputStream();
		PipedInputStream snk = new PipedInputStream();
		src.connect(snk);
		out = new DataOutputStream(src);
		in = new DataInputStream(snk);
	}
	
	public void writeIn(int value) throws IOException{
		out.writeInt(value);
	}
	
	public int readOut() throws IOException{
		return in.readInt();
	}
	
	public void close() throws IOException{
		out.close();
	}
	
}
