package Uebung_5_1;

public class AmpelTest {

	public static void main(String[] args) {
		Ampel a = new Ampel();
		
		System.out.println(a.green());
		System.out.println(a.yellow());
		System.out.println(a.green());
		
		System.out.println("");
		System.out.println("");
		
		System.out.println(a.red());
		System.out.println(a.redYellow());
		System.out.println(a.red());
		
		System.out.println("");
		System.out.println("");
		
		System.out.println(a.blink());
	}

}
