package no.hvl.dat108.oppg1;

import static java.lang.Thread.sleep;

public class Main {

    public static boolean fortsett = true;

    public static void main(String[] args) throws InterruptedException {

        UtThread t1 = new UtThread();
        t1.start();

        InnThread t2 = new InnThread();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("Tråder avsluttes...");
        System.out.println("Main avsluttes.");

    }
}