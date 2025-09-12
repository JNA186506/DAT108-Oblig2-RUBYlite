package no.hvl.dat108.oppg2;

public class Kokk extends Thread {

    private HamburgerBrett brett;
    private String navn;

    private int antallHamburgere;

    public Kokk(HamburgerBrett brett, String navn) {
       this.brett = brett;
       this.navn = navn;
       antallHamburgere = 0;
    }

    public Hamburger lagHamburger() {
        try {
            sleep(2000);
            antallHamburgere++;
        } catch (InterruptedException e) {
        }
        return new Hamburger(antallHamburgere);

    }

    public String getNavn() {
        return navn;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (brett) {
                Hamburger burger = lagHamburger();
                while (brett.isFull()) {
                   try {
                       brett.wait();
                   } catch (InterruptedException e) {
                       throw new RuntimeException(e);
                   }
                   brett.enqueue(burger);
                   brett.notifyAll();
                }
                System.out.println("Kokk " + getNavn() + " la på burger " + burger.nummer());
            }
        }
    }
}