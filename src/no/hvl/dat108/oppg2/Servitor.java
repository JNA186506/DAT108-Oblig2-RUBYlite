package no.hvl.dat108.oppg2;


public class Servitor extends Thread {

    private HamburgerBrett brett;
    private String navn;

    public Servitor(HamburgerBrett brett, String navn) {
        this.brett = brett;
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep((long) Math.floor(Math.random() * 5 + 2) * 1000);
            } catch (InterruptedException e) {
            }
            brett.serverBurger(this);
        }
    }
}
