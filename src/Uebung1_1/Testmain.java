package Uebung1_1;

import java.util.Scanner;

public class Testmain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Fach[] faecher;
		Fach f;
		//faecher[0] = new Fach(Semester.sem1, "AI", "MatheII");
		//Student s1 = new Student("s0556255", 1, faecher, "Mueller", "Hans", 1992);
		//Student s2 = new Student("s0556255", 1, faecher, "Mueller", "Hans", 1992);
		//Student s3 = new Student("s0556255", 1, faecher, "Mueller", "Hans", 1992);
		Student[] liste = new Student[0];
		int anzahl;
		int auswahl;
		String wieder = "ja";
		do{
			Student[] temp = new Student[liste.length+1]; 
			Semester sem = null;
			String kursname,studigang,mat,nachname,vorname;
			int geburtsjahr,seminargruppe;
			System.out.println("Bitte geben Sie die Anzahl der fächer an");
			anzahl = sc.nextInt();
			faecher = new Fach[anzahl];
			for(int j=0;j<anzahl;j++){
				System.out.println("Bitte geben Sie das Semester ein(1,2,3,4,5,6):");
				System.out.println("1 für das: " + sem.sem1);
				System.out.println("2 für das: " + sem.sem2);
				System.out.println("3 für das: " + sem.sem3);
				System.out.println("4 für das: " + sem.sem4);
				System.out.println("5 für das: " + sem.sem5);
				System.out.println("6 für das: " + sem.sem6);
				auswahl = sc.nextInt();
				switch (auswahl) {
				case 1:
					sem = Semester.sem1;
					break;
				case 2:
					sem = Semester.sem2;
					break;
				case 3:
					sem = Semester.sem3;
					break;
				case 4:
					sem = Semester.sem4;
					break;
				case 5:
					sem = Semester.sem5;
					break;
				case 6:
					sem = Semester.sem6;
					break;
				default:
				break;
				}
				System.out.println("Bitte geben Sie den Kursnamen ein");
				kursname = sc.next();
				System.out.println("Bitte geben Sie den Studiengang an:");
				studigang = sc.next();
				faecher[j] = new Fach(sem,studigang,kursname);
			}
			System.out.println("Bitte geben Sie die Matrikelnummer ein:");
			mat = sc.next();
			System.out.println("Bitte geben Sie die Seminargruppe ein:");
			seminargruppe = sc.nextInt();
			System.out.println("Bitte geben Sie ihren Vornamen ein:");
			vorname = sc.next();
			System.out.println("Bitte geben Sie ihren Nachnamen ein:");
			nachname = sc.next();
			System.out.println("Bitte geben Sie ihr geburtsjahr ein:");
			geburtsjahr = sc.nextInt();
			if(liste.length==0){
				temp[0] = new Student(mat,seminargruppe,faecher,vorname,nachname,geburtsjahr);
			}else{
				for(int i = 0;i<liste.length;i++){
					temp[i] = liste[i];
				}
				temp[temp.length-1] = new Student(mat,seminargruppe,faecher,vorname,nachname,geburtsjahr);
			}
			liste = temp;
			
			System.out.println(liste[liste.length-1].toString());
			
			System.out.println("Möchten Sie wiederholen? ");
			wieder = sc.next();
			
		}while(wieder.equals("ja"));
		do{
		System.out.println("Was möchten Sie tun?");
		System.out.println();
		System.out.println("1 für:		 Ein weiteres Fach hinzufügen:");
		System.out.println("2 für:		 Ein Studenten anhand der Matrikelnummer suchen:");
		System.out.println("3 für:		 Anzahl der Fächer wiedergeben:");
		System.out.println("4 für:		 Um alle Studenten auszugeben:");
		auswahl = sc.nextInt();
		switch (auswahl) {
		case 1:
			int index;
			System.out.println("Bitte geben Sie den Studenten an dem Sie ein Fach hinzufügen möchten");
			for(int i = 0; i<liste.length;i++){
				System.out.println(i+ ". für: " +liste[i].toString());
			}
			index = sc.nextInt();
			Semester semes = null;
			String studigang,kursname;
			auswahl=0;
			System.out.println("Bitte geben Sie ein semseter ein(1,2,3,4,5,6):");
			System.out.println("1 für das: " + semes.sem1);
			System.out.println("2 für das: " + semes.sem2);
			System.out.println("3 für das: " + semes.sem3);
			System.out.println("4 für das: " + semes.sem4);
			System.out.println("5 für das: " + semes.sem5);
			System.out.println("6 für das: " + semes.sem6);
			auswahl = sc.nextInt();
			switch (auswahl) {
			case 1:
				semes = Semester.sem1;
				break;
			case 2:
				semes = Semester.sem2;
				break;
			case 3:
				semes = Semester.sem3;
				break;
			case 4:
				semes = Semester.sem4;
				break;
			case 5:
				semes = Semester.sem5;
				break;
			case 6:
				semes = Semester.sem6;
				break;
			default:
			break;
			}
			System.out.println("Bitte geben Sie ein Kursname ein:");
			kursname = sc.next();
			System.out.println("Bitte geben Sie ein Studiengang ein:");
			studigang = sc.next();
			f = new Fach(semes,studigang,kursname);
			liste[index].addFaecher(f);
			System.out.println(liste[index].toString());
			System.out.println("Fach wird wieder enfernt");
			liste[index].removeFaecher(kursname);
			System.out.println(liste[index].toString());
			
			break;
		case 2:
			String mat;
			System.out.println("Bitte geben Sie die gesuchte matrikelnummer ein:");
			mat = sc.next();
			for(int i=0;i<liste.length;i++){
				if(mat.equals(liste[i].getMatrikelnummer())){
					System.out.println(liste[i].toString());
				}
			}
			break;

		case 3:
			for(int i = 0;i<liste.length;i++){
				System.out.println(liste[i].getMatrikelnummer() + ":  " + liste[i].anzahlFaecher());
			}
			break;

		case 4:
			for(int i = 0;i<liste.length;i++){
				System.out.println(liste[i].toString());
			}
			break;
			
		default:
			break;
		}
		System.out.println("Möchten Sie wiederholen?");
		wieder = sc.next();
		
		}while(wieder.equals("ja"));
		
	}
}
