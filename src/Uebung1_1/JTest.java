package Uebung1_1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JTest {
	Student s1;
	Student s2;
	Student s3;
	Student[] list;
	Fach[] faecher;
	Fach f1,f2,f3,f4,f5;
	
	@Before
	public void ini(){
		f1 = new Fach(Semester.sem1,"AI","MatheI");
		f2 = new Fach(Semester.sem2,"AI","MatheII");
		f3 = new Fach(Semester.sem3,"AI","ProgI");
		f4 = new Fach(Semester.sem4,"AI","ProgII");
		f5 = new Fach(Semester.sem5,"AI","BWL");
		faecher = new Fach[]{f1,f2};
		s1 = new Student("s05",1,faecher,"Hans","Peter",1992);
		s2 = new Student("s07",2,faecher,"Horst","Meier",1993);
		s3 = new Student("s09",1,faecher,"Peter","Mueller",1994);
		list = new Student[]{s1,s2,s3};
	}
	
	@Test
	public void testAddFaecher() {
		s1.addFaecher(f3);
		faecher = s1.getFaecher();
		assertTrue(faecher[2] == f3);
	}
	@Test
	public void testAddFaechermax() {
		s1.addFaecher(f3);
		s1.addFaecher(f5);
		s1.addFaecher(f1);
		faecher = s1.getFaecher();
		assertTrue(faecher.length ==4);
	}
	@Test
	public void testremoveFaecher() {
		s1.removeFaecher("MatheI");
		faecher = s1.getFaecher();
		assertTrue(faecher.length == 1);
	}
	@Test
	public void testAnzahlFaecher() {
		assertTrue(s2.anzahlFaecher()==2);
	}
	@Test
	public void testVornameNachname() {
		assertTrue(Student.vornameNachname(list, "s05").equals("Vorname: Hans Nachname: Peter"));
	}
	
}
