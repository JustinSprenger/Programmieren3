package Uebung1;

import java.util.Scanner;

import Uebung1.Enum.Verlag;

public class Test {
	
	public static void main(String[] args) {
		int auswahl;
		Scanner sc = new Scanner(System.in);
		Buch[] libary = new Buch[0];
		String wieder="no";
		do{
			
		
		System.out.println("----------------------------------------");
		System.out.println("----------------------------------------");
		System.out.println("----------------------------------------");
		System.out.println("---------------Buchladen----------------");
		System.out.println("----------------------------------------");
		System.out.println("----------------------------------------");
		System.out.println("----------------------------------------");
		System.out.println("Bitte geben Sie an was Sie machen m�chten:");
		System.out.println("geben Sie eine		 1 			ein um ein neues buch zu registrieren");
		System.out.println("geben Sie eine		 2 			ein um nach einem Buch anhand des Jahres zu suchen");
		System.out.println("geben Sie eine		 3 			ein um den Autor und Titel eines Buches zu ändern");
		System.out.println("geben Sie eine		 4 			ein um ein Buch zu entfernen");
		System.out.println("geben Sie eine		 5 			ein um sich ein Buch ausgeben zu lassen");
		auswahl = Integer.parseInt(sc.next());
				
		switch (auswahl) {
		case 1:
			int id,jahr;
			int index;
			Buch[] temp;
			
			String autor,titel,isbn;
			Enum.Verlag verlag;
			
			if(libary.length == 5){
				break;
			}
			
			System.out.println("Bitte geben Sie eine ID ein:");
			id = sc.nextInt();
			System.out.println("Bitte geben Sie einen Autor an:");
			autor = sc.next();
			System.out.println("Bitte geben Sie den Titel ein:");
			titel = sc.next();
			System.out.println("Bitte geben Sie eine ISBN ein:");
			isbn = sc.next();
			System.out.println("Bitte geben Sie ein Erscheinungsdatum an:");
			jahr = sc.nextInt();
			System.out.println("Bitte geben Sie ein Verlag an(1,2,3,4 oder 5):");
			auswahl = sc.nextInt();
			switch (auswahl) {
			case 1:
				verlag = Enum.Verlag.Verlag1;
				break;
			case 2:
				verlag = Enum.Verlag.Verlag2;
				break;
			case 3:
				verlag = Enum.Verlag.Verlag3;
				break;
			case 4:
				verlag = Enum.Verlag.Verlag4;
				break;
			case 5:
				verlag = Enum.Verlag.Verlag5;
				break;
				
			default:
				System.out.println("Sie haben keinen gültigen verlag gewählt, er wurde deshalb auf 1 gesetzt");
				verlag = Enum.Verlag.Verlag1;
				break;
			}
			
			if(libary.length == 0){
				temp = new Buch[1];
				temp[0] = new Buch(id,autor,titel,isbn,jahr,verlag);
				libary = temp;
			}else{
				index = libary.length + 1;
				temp = new Buch[index];
				for(int i = 0;i<index-1;i++){
					temp[i] = libary[i];
				}
				temp[index-1] = new Buch(id,autor,titel,isbn,jahr,verlag);
				libary = temp;
			}
			
			//libary.add(new Buch(id,autor,titel,isbn,jahr,verlag));
			break;
		case 2:
			int jahr1;
			System.out.println("Bitte geben Sie ein Jahr ein");
			jahr1 = sc.nextInt();
			Buch.isFrom(jahr1, libary);
			break;
		case 3:
			int ids;
			int zahl;
			String autor2;
			System.out.println("Bitte geben Sie ein von welchem Buch Sie den autor ändern möchten(BuchID)");
			ids = sc.nextInt();
			zahl = Buch.idsearch(ids, libary);
			libary[zahl].toString();
			System.out.println("Bitte geben Sie den neuen Autor ein:");
			autor2 = sc.next();
			libary[zahl].editAutor(autor2);
			
			break;
		case 4:
			int rid,zaehler=0;;
			Buch[] rtemp = new Buch[libary.length-1];
			for(int i = 0;i<libary.length;i++){
				System.out.println(libary[i].showIDTitel());
			}
			System.out.println("Bitte geben Sie die Buch-ID ein:");
			rid = sc.nextInt();
			
			for(int i = 0;i<rtemp.length;i++){
				if(rid == i){
					i++;
					zaehler++;
				}else{
					
					rtemp[zaehler] = libary[i];
					zaehler++;
				}
				
			}
			libary = rtemp;
			break;
		case 5:
			int bid;
			System.out.println("Bitte geben Sie die Buch-ID ein:");
			bid = sc.nextInt();
			System.out.println(libary[Buch.idsearch(bid, libary)].toString());
			break;

		default:
			System.out.println("Error");
			break;
		}
		
		System.out.println("M�chten Sie wiederhohlen");
		wieder = sc.next();	
	}while(wieder.equals("ja"));	
	}	
}
