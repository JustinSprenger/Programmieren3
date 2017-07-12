package Uebung_4_22;

import java.util.List;
import java.util.Vector;

public class Main {

	public static void main(String[] args) {
		try {
		Pipe pipe = new Pipe();
		Produzent p = new Produzent(pipe);
		Konsument k = new Konsument(pipe);
		
		Thread kons = new Thread(k);
		p.start();
		kons.start();
		
		
			
		boolean w = true;
		int buf;
		key:
		while(w==true){
			buf = System.in.read();
			switch (buf) {
			case 's':
				p.interrupt();
				System.out.println("gestopt");
			break;
			case 'c':
				synchronized(p){
					p.consume();
					System.out.println("weiter");	
				}
			break;
			case 'p':
				synchronized(p){
					p.pause();
					System.out.println("pause");
				}
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
