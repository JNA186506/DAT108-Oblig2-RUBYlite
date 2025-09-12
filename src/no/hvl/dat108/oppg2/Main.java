package no.hvl.dat108.oppg2;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        final String[] kokker = {"Anne", "Erik", "Knut"};
        final String[] servitorer = {"Mia", "Per"};

        HamburgerBrett brett = new HamburgerBrett(4);

        Kokk anne = new Kokk(brett, "anne");
        Servitor per = new Servitor(brett, "per");

        anne.start();
        per.start();

    }
}
