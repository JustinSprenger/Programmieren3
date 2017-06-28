package Uebung_4_22;

import java.util.List;
import java.util.Vector;

public class Main {

	public static void main(String[] args) {
		Vector<Integer> l1 = new Vector<>();
		
		Produzent p1 = new Produzent(l1);
		Thread p = new Thread(p1);
		
		
		
		p.start();
		
		Konsument k1 = new Konsument(l1);
		Thread k = new Thread(k1);
		
		k.start();
		try {
			
		boolean w = true;
		int buf;
		key:
		while(w==true){
			buf = System.in.read();
			switch (buf) {
			case 's':
				p.stop();
				k.stop();
				System.out.println("gestopt");
			break;
			case 'c':
				p1.consume();
				System.out.println("weiter");
			break;
			case 'p':
				p1.pause();
				System.out.println("pause");
			break;

			default:
				break;
			}
			buf = 0;
		}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
