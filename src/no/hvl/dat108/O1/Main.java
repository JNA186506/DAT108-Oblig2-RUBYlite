package no.hvl.dat108.oppg1;

import javax.swing.*;

import static java.lang.Thread.sleep;

public class Main {

    public static boolean fortsett = true;

    public static void main(String[] args) throws InterruptedException {

        String forsteMelding = JOptionPane.showInputDialog(null, "Skriv inn melding");

        Melding melding = new Melding(forsteMelding);

        UtThread t1 = new UtThread(melding);
        t1.start();

        InnThread t2 = new InnThread(melding);
        t2.start();

        t1.join();
        t2.join();
        System.out.println("Tråder avsluttes...");
        System.out.println("Main avsluttes.");

    }
}