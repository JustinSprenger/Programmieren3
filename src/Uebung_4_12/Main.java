package Uebung_4_12;

public class Main {

	public static void main(String[] args) {
		Konto k = new Konto();
		MyThread t = new MyThread(k);
		MyThreade e = new MyThreade(k);
		
		e.start();
		t.run();
		
		
		
		System.out.println(e.anzahl()+t.anzahl());
		System.out.println(k.anzahl());
		System.out.println(k.betragAusgeben());
		
	}

}
