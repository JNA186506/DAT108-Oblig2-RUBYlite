package no.hvl.dat108.oppg2;

public class Kokk extends Thread {

    private HamburgerBrett<Hamburger> brett;
    private String navn;

    private int antallHamburgere;

    public Kokk(HamburgerBrett<Hamburger> brett, String navn) {
       this.brett = brett;
       this.navn = navn;
       antallHamburgere = 0;
    }

    public String getNavn() {
        return navn;
    }
    @Override
    public synchronized void run() {
        while (true) {
            synchronized (brett) {
                try {
                    brett.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                antallHamburgere++;
                Hamburger burger = new Hamburger(antallHamburgere);
                brett.enqueue(burger);

                System.out.println(getNavn() + " la på hamburger " + burger.nummer());
                brett.notifyAll();
            }
        }
    }
}
