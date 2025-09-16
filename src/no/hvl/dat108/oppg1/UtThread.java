package no.hvl.dat108.oppg1;

public class UtThread extends Thread {

    private Melding melding;

    public UtThread(Melding melding) {
        this.melding = melding;
    }

    @Override
    public void run() {
        while (Main.fortsett) {
            try {
                sleep(3000);
                System.out.println(melding.getTekst());
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
