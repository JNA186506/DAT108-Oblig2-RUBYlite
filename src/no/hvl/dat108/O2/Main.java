package no.hvl.dat108.O2;

public class Main {
	
	public static void main(String[] args) {
		
		HamburgerBrett brett = new HamburgerBrett(5);
		Kokk kokk1 = new Kokk(brett, "Mitch");
		Kokk kokk2 = new Kokk(brett, "Mitchy");
		Kokk kokk3 = new Kokk(brett, "Mitchey");
		Servitor servitor = new Servitor(brett, "Michelle");
		
		kokk1.start();
		kokk2.start();
		kokk3.start();
		servitor.start();
		
	}
	
}
