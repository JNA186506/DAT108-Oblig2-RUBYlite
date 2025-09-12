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
	
	public boolean addHamburger() {
		
		if(hamburgere.size() < capacity) {
			
			hamburgere.add(new Hamburger(++burgerNumber));
			return true;
			
		}
		
		else {
			
			System.out.println("Brettet er fullt");
			return false;
			
		}
		
	}
	
	public Hamburger removeHamburger() {
		
		if(hamburgere.isEmpty()) return null;
		else return hamburgere.remove(0);
		
	}
	
}
