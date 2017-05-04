package Uebung1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Uebung1.Enum.Verlag;

public class BuchJTest {
	private Buch b1;
	private Buch b2;
	
	@Before
	public void objektErzeugen(){
		b1 = new Buch(23,"Hans","wurst","1234-5678-4012",1992,Enum.Verlag.Verlag1);
		
	}
	
	@Test
	public void objektTest() {
		b2 = new Buch(23,"Hans","wurst","1234-5678-4012",1992,Enum.Verlag.Verlag1);
		
	}
	@Test
	public void setgetId() {
		b1.setId(1);
		assertTrue(b1.getId()==1);
		
	}
	@Test
	public void setgetAutor() {
		b1.editAutor("Peter");;
		assertTrue(b1.getAutor()=="Peter");
	}
	@Test
	public void setgetTitel() {
		b1.setTitel("Taugenichts");
		assertTrue(b1.getTitel()=="Taugenichts");
	}
	@Test
	public void setgetIsbn() {
		b1.setIsbn("1234-5678-9012");
		assertTrue(b1.getIsbn()=="1234-5678-9012");
	}
	@Test
	public void setgetJahr() {
		b1.setEjahr(1995);
		assertTrue(b1.getEjahr()==1995);
	}
	@Test
	public void setgetVerlag() {
		b1.setVerlag(Verlag.Verlag1);
		assertTrue(b1.getVerlag()==Verlag.Verlag1);
	}
	@Test
	public void showAutorTitel() {
		b1.setAutor("Hans");
		b1.setTitel("Taugenichts");
		assertTrue(b1.showAutorTitel().equals("Autor:  HansTitel:   Taugenichts"));
	}
	@Test
	public void showIDIsbn() {
		b1.setId(1);
		b1.setIsbn("1234567890");
		assertTrue(b1.showIDIsbn().equals("ID:  1ISBN:   1234567890"));
	}
}
