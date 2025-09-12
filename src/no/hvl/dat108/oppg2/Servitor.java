package no.hvl.dat108.oppg2;


public class Servitor extends Thread {

    private HamburgerBrett brett;
    private String navn;
    private Hamburger burger;

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
            synchronized (brett) {
                while (brett.isEmpty()) {
                    try {
                        brett.wait();
                    } catch (InterruptedException e) {

                    }
                    brett.dequeue();
                    System.out.println(getNavn() + " plukket opp " + burger.nummer());
                }
            }
        }
    }
}
