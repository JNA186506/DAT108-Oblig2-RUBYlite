package no.hvl.dat108.O2;

public class Main {
	
	public static void main(String[] args) {
		
		HamburgerBrett brett = new HamburgerBrett(5);
		Kokk kokk1 = new Kokk(brett, "Mitch");
		Kokk kokk2 = new Kokk(brett, "Mitchy");
		Kokk kokk3 = new Kokk(brett, "Mitchey");
		Servitor servitor1 = new Servitor(brett, "Michelle");
		Servitor servitor2 = new Servitor(brett, "Michette");
		Servitor servitor3 = new Servitor(brett, "Michelline");
		
		kokk1.start();
		kokk2.start();
		kokk3.start();
		servitor1.start();
		servitor2.start();
		servitor3.start();
		
	}
	
}
