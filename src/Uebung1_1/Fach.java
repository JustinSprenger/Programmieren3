package Uebung1_1;

public class Fach {
	private Semester sem;
	private String studiengang, kursname;
	
	Fach(){
		
	}
	
	Fach(Semester s,String stugang,String kname){
		this.sem = s;
		this.studiengang = stugang;
		this.kursname = kname;
	}
	
	Fach(Fach fach){
		this.sem = fach.sem;
		this.kursname = fach.kursname;
		this.studiengang = fach.studiengang;
	}

	public Semester getSem() {
		return sem;
	}

	public void setSem(Semester sem) {
		this.sem = sem;
	}

	public String getStudiengang() {
		return studiengang;
	}

	public void setStudiengang(String studiengang) {
		this.studiengang = studiengang;
	}

	public String getKursname() {
		return kursname;
	}

	public void setKursname(String kursname) {
		this.kursname = kursname;
	}

	@Override
	public String toString() {
		return "Fach--> [Semester: " + sem + ", Studiengang: " + studiengang + ", Kursname: " + kursname + "] 	";
	}
	
}
