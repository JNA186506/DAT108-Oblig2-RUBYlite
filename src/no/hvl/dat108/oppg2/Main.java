package no.hvl.dat108.oppg2;

public class Main {

    public static void main(String[] args) {
        final String[] kokker = {"Anne", "Erik", "Knut"};
        final String[] servitorer = {"Mia", "Per"};

        HamburgerBrett<Hamburger> brett = new HamburgerBrett<>();

        for (String navn : kokker) {
            new Kokk(brett, navn).start();
        }

        for (String navn : servitorer) {
            new Servitor(brett, navn).start();
        }

    }
}
