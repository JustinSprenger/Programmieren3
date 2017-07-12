package Uebung_4_11;

public class Main {

	public static void main(String[] args) {
		MyThread t = new MyThread();
		MyThreade e = new MyThreade();
		
		e.start();
		t.run();
	}


}
