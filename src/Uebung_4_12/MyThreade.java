package Uebung_4_12;

public class MyThreade extends Thread {
	Konto k;
	int i=0;
	MyThreade(Konto b){
		k=b;
	}
	
	public void run(){
		int j = 0;
		do{
			synchronized (getClass()) {
				k.additionBetrag(Math.random());
				i++;
				j++;
			}
		try {
			Thread.sleep(10);
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
