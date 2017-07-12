package Uebung_4_12;

public class MyThread implements Runnable {
	Konto k;
	int i=0;
	MyThread(Konto b){
		k=b;
	}
	
	@Override
	public void run() {
		int j = 0;
		double zw = 0;
		do{
			double random = Math.random();
			synchronized (k) {
				k.additionBetrag(random);
			}
			zw = zw + random;
			i++;
			j++;
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}while(j != 20);
		System.out.println("1.Thread: "+zw);
	}
	public int anzahl(){
		return i;
	}
}
