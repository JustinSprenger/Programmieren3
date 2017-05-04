package Uebung1_1;

public class Person {
	String fname,vname;
	int gebjahr;
	
	Person(String f,String v,int geb){
		this.fname = f;
		this.vname = v;
		this.gebjahr = geb;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getVname() {
		return vname;
	}

	public void setVname(String vname) {
		this.vname = vname;
	}

	public int getGebjahr() {
		return gebjahr;
	}

	public void setGebjahr(int gebjahr) {
		this.gebjahr = gebjahr;
	}

	@Override
	public String toString() {
		return "Person--> [Vorname: " + fname + ", Nachname: " + vname + ", Geburtsjahr:" + gebjahr + "] 	";
	}
	
}
