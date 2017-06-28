package Uebung_4_21;

import java.util.List;
import java.util.Vector;

public class Main {

	public static void main(String[] args) {
		Vector<Integer> l1 = new Vector<>();
		
		Produzent p1 = new Produzent(l1);
				
		p1.start();
		
		Konsument k1 = new Konsument(l1);
		Thread k = new Thread(k1);
		
		k.start();
		try {
			

		int buf;
		Control:
		while(true){
			buf = System.in.read();
			switch (buf) {
			case 's':
				p1.interrupt();
				k.interrupt();
				System.out.println("beendet");
			break;
			case 'p':
				synchronized (p1){
					p1.pause();
					System.out.println("stoppen");
				}
				
			break;
			case 'c':
				synchronized (p1) {
					p1.consume();
					System.out.println("weiter");
				}
				
			break;	
			}
			
		  }
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
