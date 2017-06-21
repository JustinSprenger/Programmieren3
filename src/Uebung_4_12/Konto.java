package Uebung_4_12;

public class Konto {
	double betrag;
	int anz =0;
	Konto(){
		
	}
	
	public void additionBetrag(double betrag){
		this.betrag = this.betrag + betrag;
		anz = anz + 1;
	}
	
	public double betragAusgeben(){
		return betrag;
	}
	public int anzahl(){
		return anz;
	}
}
