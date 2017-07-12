package Uebung_4_22;

import java.io.IOException;
import java.util.Random;
import java.util.Vector;

public class Produzent extends Thread {
	Pipe pipe;
	Random random = new Random();
	private boolean stop = false;
	
	Produzent(Pipe p){
		this.pipe = p;
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
					pipe.writeIn(zahl);
					System.out.println(zahl + "     -Produzent");
					Thread.sleep(2000);
				}
				
		} catch (InterruptedException e) {
		} catch (IOException e) {
			System.err.println(e);
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
