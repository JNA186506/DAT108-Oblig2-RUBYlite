package no.hvl.dat108.O3;

public class Kokk extends Thread {
	
	private HamburgerBrett brett;
	private String namn;
	
	public Kokk(HamburgerBrett brett, String namn) {
		
		this.brett = brett;
		this.namn = namn;
		
	}
	
	public String getNamn() {
		
		return namn;
		
	}
	
	@Override
	public void run() {
		
		while(true) {
			
			try {
				
				Thread.sleep((2 + (int) Math.floor(Math.random() * 5)) * 1000);
				
			}
			
			catch (InterruptedException e) {
				
				e.printStackTrace();
				
			}
			
			brett.addHamburger(this);
			
		}
		
	}
	
}