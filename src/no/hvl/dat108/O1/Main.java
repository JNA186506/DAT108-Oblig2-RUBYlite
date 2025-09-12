package no.hvl.dat108.O1;

import javax.swing.JOptionPane;

public class Main {
	
	static String melding;
	static boolean done;
	
	public static void main(String[] args) {
		
		melding = "";
		done = false;
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				while(!done && melding != null) {
					
					System.out.println(melding);
					
					try {
						
						Thread.sleep(3000);
						
					}
					
					catch (InterruptedException e) {
						
						e.printStackTrace();
						
					}
					
				}
				
			}
			
		});
		
		t1.start();
		
		while(!done) {
			
			melding = JOptionPane.showInputDialog(null, "Write in a message to print (write 'done' to shut down): ", "Avbryt", JOptionPane.PLAIN_MESSAGE);
			
			if(melding == null) done = true;
			else if(melding.toLowerCase().equals("done")) done = true;
			
		}
		
	}
	
}
