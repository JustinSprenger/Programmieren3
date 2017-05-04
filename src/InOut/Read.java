package InOut;

import java.util.Scanner;

public class Read {
	Scanner sc = new Scanner(System.in);
	Read(){
		
	}
	public int readInt(){
		String s;
		int z=0;
		boolean w=true;
		do{
			s = sc.next();
			try {
				z = Integer.parseInt(s);
				w = true;
			} catch (Exception e) {
				System.out.println("Bitte geben Sie eine ganze Zahl ein!!!");
				w = false;
			}
		}while(w==false);
		return z;
	}
	public double readDouble(){
		String s;
		double z=0;
		boolean w=true;
		do{
			s = sc.next();
			try {
				z = Double.parseDouble(s);
				w = true;
			} catch (Exception e) {
				System.out.println("Bitte geben Sie eine Zahl ein!!!");
				w = false;
			}
		}while(w==false);
		return z;
	}
	public char readChar(){
		String s;
		char c=' ';
		boolean w=true;
		do{
			s = sc.next();
			try {
				c = s.charAt(0);
				w = true;
			} catch (Exception e) {
				System.out.println("Bitte geben Sie einen Buchstaben ein!!!");
				w = false;
			}
		}while(w==false);
		return c;
	}
}
