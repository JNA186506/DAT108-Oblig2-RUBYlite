package no.hvl.dat108.O3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class HamburgerBrett {
	
	private BlockingQueue<Hamburger> hamburgere;
	private int burgerNumber;
	
	public HamburgerBrett(int capacity) {
		
		hamburgere = new ArrayBlockingQueue<>(capacity);
		burgerNumber = 0;
		
	}
	
	public void addHamburger(Kokk k) {
		
		try {
			
			Hamburger h = new Hamburger(++burgerNumber);
			hamburgere.put(h);
			System.out.println("Laget av " + k.getNamn() + ": " + h.getNummer());
			
		}
		
		catch (InterruptedException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public void removeHamburger(Servitor s) {
		
		Hamburger hb = null;
		
		try {
			
			hb = hamburgere.take();
			
		}
		
		catch (InterruptedException e) {
			
			e.printStackTrace();
			
		}
		
		System.out.println("Servert av " + s.getNamn() + ": " + hb.getNummer());
		
	}
	
}
