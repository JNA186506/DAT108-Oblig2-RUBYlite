package no.hvl.dat108.oppg2;


public class Servitor extends Thread {

    private HamburgerBrett<Hamburger> brett;
    private String navn;

    public Servitor(HamburgerBrett<Hamburger> brett, String navn) {
        this.brett = brett;
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    @Override
    public synchronized void run() {
        while (true) {
            synchronized (brett) {
                while(brett.getLengde() != 0) {
                    try {
                        brett.wait();
                    } catch (InterruptedException e) {
                    }

                    Hamburger hamburger = brett.dequeue();
                    brett.notifyAll();
                    System.out.println("Servitor tar av hamburger " + hamburger.nummer());
                    brett.print();
                }

            }
        }
    }
}
