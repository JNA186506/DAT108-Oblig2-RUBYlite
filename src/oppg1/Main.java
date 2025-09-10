package oppg1;

import static java.lang.Thread.sleep;

public class Main {

    public static boolean fortsett = true;

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() ->  {
            while (fortsett) {
                try {
                    System.out.println("Hallo verden!");
                    sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();

        InputThread t2 = new InputThread();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("Tråder avsluttes...");
        System.out.println("Main avsluttes.");

    }
}