package Uebung1_1;

import java.util.Arrays;

public class Student extends Person implements Sudiinfo {
	String matrikelnummer; 
	int seminargruppe;
	Fach[] faecher = new Fach[0];
	/**
	 * Matrikelnummer,Seminargruppe,Fächer,Familienname,Vorname,Geburtsjahr
	 * @param matr -Matrikelnummer
	 * @param semgruppe -Seminargruppe
	 * @param faecher -Fächer
	 * @param f -Familienname
	 * @param v -Vorname
	 * @param geb -Geburtsjahr
	 */
	
	Student(String matr,int semgruppe,Fach[] faecher,String f,String v,int geb){
		super(f,v,geb);
		this.matrikelnummer = matr;
		this.seminargruppe = semgruppe;
		this.faecher = faecher;
	}

	public String getMatrikelnummer() {
		return matrikelnummer;
	}

	public void setMatrikelnummer(String matrikelnummer) {
		this.matrikelnummer = matrikelnummer;
	}

	public int getSeminargruppe() {
		return seminargruppe;
	}

	public void setSeminargruppe(int seminargruppe) {
		this.seminargruppe = seminargruppe;
	}

	public Fach[] getFaecher() {
		return faecher;
	}

	public void setFaecher(Fach[] faecher) {
		this.faecher = faecher;
	}

	@Override
	public String toString() {
		return super.toString()+"Student--> [Matrikelnummer: " + matrikelnummer + ", Seminargruppe: " + seminargruppe + ", Faecher: "
				+ Arrays.toString(faecher) + "] 	";
	}

	@Override
	public int anzahlFaecher() {
		return faecher.length;
	}

	static String vornameNachname(Student[] list,String matrikelnummer) {
		String erg="";
		for(int i = 0; i<list.length;i++){
			if(matrikelnummer == list[i].getMatrikelnummer()){
				erg = "Vorname: "+list[i].getFname() + " Nachname: " + list[i].getVname();
			}
		}
		return erg;
	}

	@Override
	public void addFaecher(Fach f) {
		Fach[] temp = new Fach[faecher.length+1];
		if(faecher.length == 0){
			temp[0] = f;
		}else if(faecher.length<4){
			for(int i = 0;i<faecher.length;i++){
				temp[i] = faecher[i];
			}
			temp[temp.length-1] = f;
			faecher = temp;
		}else{
			System.out.println("Es sind bereits 4 Fächer eingetragen!");
		}
		
	}

	@Override
	public void removeFaecher(String kursname) {
		Fach[] temp = new Fach[faecher.length-1];
		int z=0;
		for(int i=0;i<temp.length;i++){
			if(kursname == faecher[i].getKursname()){
				i++;
				z++;
			}else{
				temp[z] = faecher[i];
				z++;
			}
		}
		faecher = temp;
	}
	
}
