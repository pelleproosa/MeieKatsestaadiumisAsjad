package Herman;

public class Massiivid3 {

	public static void start() {
		
System.out.println("Hermani massiivid3 jookseb hetkel!");
		
		String [][] multiMassiivNimed = {
				{"Hr", "Pr", "", "X"},
				{"Herman", "Pelle", "Helen"},
				{"Proosa", "K�rtner", "Tamm", "Kask", "Petrov", "Lenin"}
		};
		
		System.out.println("Massiivide programm k�ib hetkel iseseisvalt. Autor on : "
				+multiMassiivNimed[0][0]
				+" "
				+multiMassiivNimed[1][0]
				+" "
				+multiMassiivNimed[2][0]);
		
		/*
		//alternatiiv
		 * String multiMassiivNimed[][]; 
		multiMassiivNimed = new String[2][3];
		/m��ran nimed bla bla �kshaaval
		*/
		
	
		
	}

}
