package no.hvl.dat108.O2;

import java.util.ArrayList;

public class HamburgerBrett {
	
	private ArrayList<Hamburger> hamburgere;
	private int capacity;
	private int burgerNumber;
	
	public HamburgerBrett(int capacity) {
		
		this.capacity = capacity;
		hamburgere = new ArrayList<>();
		burgerNumber = 0;
		
	}
	
	public int getBurgerNumber() {
		
		return burgerNumber;
		
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
				
				System.out.println("Laget av " + k.getNamn() + ": " + h.getNummer());
				
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
				
				System.out.println("Servert av " + s.getNamn() + ": " + hamburgere.remove(0).getNummer());
				
				this.notify();
				
			}
			
		}
		
	}
	
}
