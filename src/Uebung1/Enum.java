package Uebung1;

public class Enum {
	
	public enum Verlag{
		Verlag1("erster Verlag"),
		Verlag2("zweiter Verlag"),
		Verlag3("dritter Verlag"),
		Verlag4("vierter Verlag"),
		Verlag5("fuenfter Verlag");

		private String name;
		Verlag(String verlagname){
			name = verlagname;
		}
		public String getVerlagName(){
			return name;
		}
	}
}
