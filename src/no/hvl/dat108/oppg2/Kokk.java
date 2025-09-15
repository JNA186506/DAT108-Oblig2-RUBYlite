package no.hvl.dat108.oppg2;

public class Kokk extends Thread {

    private HamburgerBrett brett;
    private String navn;

    public Kokk(HamburgerBrett brett, String navn) {
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
                System.out.println("Error");
            }
            brett.addBurger(this);
        }
    }
}