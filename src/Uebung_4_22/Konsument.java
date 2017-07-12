package Uebung_4_22;

import java.io.EOFException;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;

public class Konsument implements Runnable {
	Pipe pipe;
	

	Konsument(Pipe p) {
		this.pipe = p;
	}

	@Override
	public void run() {
		int zahl = 0;

		try {
			
			while (true) {
				
				String stern ="";
				zahl = pipe.readOut();
				for(int i = 0;i<zahl;i++){
					stern = stern + "*";
				}						
				System.out.println(stern);
				System.out.println();
				
			}
		} catch (EOFException e) {
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
}
