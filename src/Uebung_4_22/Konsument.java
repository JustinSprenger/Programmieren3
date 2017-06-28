package Uebung_4_22;

import java.util.Random;
import java.util.Vector;

public class Konsument implements Runnable {
	Vector zahlen;
	

	Konsument(Vector a) {
		this.zahlen = a;
	}

	@Override
	public void run() {
		int zahl = 0;

		try {
			while (true) {
				synchronized (this) {

					
					if(zahlen.size()>0){
						String stern ="";
						zahl = (int) zahlen.get(0);
						zahlen.removeElementAt(0);
						
						for (int i = 0; i < zahl; i++) {
							stern = stern + "*";
						}
						System.out.println(stern);
						System.out.println();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
}
