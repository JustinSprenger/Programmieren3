package Uebung_4_11;

public class MyThread implements Runnable {
	
	@Override
	public void run() {
		boolean j = false;
		do{
			System.out.println("Hop");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}while(j == false);
		
	}
}
