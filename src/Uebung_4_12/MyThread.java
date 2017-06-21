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
		do{
			synchronized (getClass()) {
				k.additionBetrag(Math.random());
				i++;
				j++;
			}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}while(j != 20);
		System.out.println(i);
	}
	public int anzahl(){
		return i;
	}
}
