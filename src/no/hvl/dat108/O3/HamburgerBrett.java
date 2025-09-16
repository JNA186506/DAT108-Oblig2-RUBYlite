package no.hvl.dat108.O3;

import java.util.ArrayList;
import java.util.List;
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
			System.out.println( k.getNamn() + " lagde burger nummer: " + h.getNummer()
			+ ", Brettet inneholder: " + this);
			
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
		
		System.out.println(s.getNamn() + " serverte burger nummer: " + hb.getNummer()
		+ ", Brettet inneholder: " + this);
		
	}

	public String toString() {
		List<Integer> s = new ArrayList<>();

		for (Hamburger burger : hamburgere) {
			s.add(burger.getNummer());
		}

		return String.join(", ", s.toString());
	}

}
