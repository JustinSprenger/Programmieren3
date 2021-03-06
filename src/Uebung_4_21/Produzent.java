package Uebung_4_21;

import java.util.Random;
import java.util.Vector;

public class Produzent extends Thread{
	Vector zahlen;
	Random random = new Random();
	private volatile boolean stop = false;
	
	Produzent(Vector a){
		this.zahlen = a;
	}
	
	@Override
	public void run() {
		int zahl = 0;
		try {
			while(true) {
				synchronized (this) {
					while (stop) {
						wait();
					}
				}
				zahl = 1 + random.nextInt(59);
				zahlen.add(zahl);
				System.out.println(zahl + "     -Produzent");
				Thread.sleep(2000);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void pause() {
		this.stop = true;
	}

	public void consume() {
		this.stop = false;
		notify();
	}
}
