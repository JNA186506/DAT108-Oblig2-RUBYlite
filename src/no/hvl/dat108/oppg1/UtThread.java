package no.hvl.dat108.oppg1;

public class UtThread extends Thread {

    @Override
    public void run() {
        while (Main.fortsett) {
            try {
                System.out.println("En melding");
                sleep(3000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
