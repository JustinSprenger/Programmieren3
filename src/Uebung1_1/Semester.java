package Uebung1_1;

public enum Semester{
		sem1("1.Semester"),
		sem2("2.Semester"),
		sem3("3.Semester"),
		sem4("4.Semester"),
		sem5("5.Semester"),
		sem6("6.Semester");

		private String name;
		Semester(String semester){
			name = semester;
		}
		public String getSemester(){
			return name;
		}
}

