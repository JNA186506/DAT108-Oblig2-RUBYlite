package no.hvl.dat108.O2;

import java.util.ArrayList;
import java.util.List;

public class HamburgerBrett {
	
	private ArrayList<Hamburger> hamburgere;
	private int capacity;
	private int burgerNumber;
	
	public HamburgerBrett(int capacity) {
		
		this.capacity = capacity;
		hamburgere = new ArrayList<>();
		burgerNumber = 0;
		
	}
	
	public void addHamburger(Kokk k) {
		
		synchronized(this) {
			
			if(hamburgere.size() >= capacity) {
				
				System.out.println("Brettet er fullt!");
				
				try {
					
					this.wait();
					
				}
				
				catch (InterruptedException e) {}
				
			}
			
			else {
				
				Hamburger h = new Hamburger(++burgerNumber);
				
				System.out.println(k.getNamn() + " lagde burger nummer: " + h.getNummer() + ", Brettet inneholder: " + this);
				
				hamburgere.add(h);
				
				this.notify();
				
			}
			
		}
		
	}
	
	public void removeHamburger(Servitor s) {
		
		synchronized(this) {
			
			if(hamburgere.isEmpty()) {
				
				System.out.println("Brettet er tomt!");
				
				try {
					
					this.wait();
					
				}
				
				catch (InterruptedException e) {}
				
			}
			
			else {
				
				System.out.println( s.getNamn() + " serverte burger nummer: " + hamburgere.removeFirst().getNummer()
				 + " Brettet inneholder: " + this);
				
				this.notify();
				
			}


			
		}
		
	}

	public String toString() {
		List<Integer> s = new ArrayList<>();

		for (Hamburger burger : hamburgere) {
			s.add(burger.getNummer());
		}

		return String.join(", ", s.toString());
	}
	
}
