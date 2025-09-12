package no.hvl.dat108.O2;

public class Servitor extends Thread {
	
	private boolean done;
	private HamburgerBrett brett;
	private String namn;
	
	public Servitor(HamburgerBrett brett, String namn) {
		
		done = false;
		this.brett = brett;
		this.namn = namn;
		
	}
	
	public String getNamn() {
		
		return namn;
		
	}
	
	public void setNamn(String namn) {
		
		this.namn = namn;
		
	}
	
	@Override
	public void run() {
		
		while(!done) {
			
			Hamburger burger = brett.removeHamburger();
			
			if(burger != null) {
				
				System.out.println(namn + " serverte hamburger {" + burger.getNummer() + "}");
				
				try {
					
					Thread.sleep((2 + (int) Math.floor(Math.random() * 5)) * 1000);
					
				}
				
				catch (InterruptedException e) {
					
					e.printStackTrace();
					
				}
				
			}
			
			else {
				
				System.out.println("Brettet er tomt");
				
				
				
			}
			
		}
		
	}
	
	public void stopp() {
		
		done = true;
		
	}
	
}
