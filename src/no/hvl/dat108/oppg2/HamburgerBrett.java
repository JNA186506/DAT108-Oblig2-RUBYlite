package no.hvl.dat108.oppg2;

import java.util.*;
import java.util.stream.Stream;

import static java.lang.Thread.sleep;

public class HamburgerBrett {

    private Queue<Hamburger> brett;
    private int capacity;
    private int burgernummer;

    public HamburgerBrett(int capacity) {
        this.brett = new LinkedList<>();
        this.burgernummer = 0;
        this.capacity = capacity;
    }

    public synchronized void addToBrett(Hamburger burger) {
        brett.add(burger);
    }

    public synchronized void addBurger(Kokk kokk) {
        while (isFull()) {
            System.out.println("Brettet er fullt, kokk " + kokk.getNavn() + " venter...");
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        Hamburger burger = new Hamburger(++burgernummer);
        addToBrett(burger);
        notifyAll();
        System.out.print("Kokk " + kokk.getNavn() + " la på hamburger " + burger.nummer() +
                " på brettet ligger: " + this);
        System.out.println();
    }

    public synchronized void serverBurger(Servitor servitor) {
        while (isEmpty()) {
            try {
                System.out.println("Brettet er tomt servitør " + servitor.getNavn() + " venter...");
                wait();
            } catch (InterruptedException e) {
                System.out.println("Error");
            }
        }
        System.out.print("Servitor " + servitor.getNavn() + " serverte burger " + brett.remove().nummer() + " brettet inneholder: "
                + this);
        notifyAll();
        System.out.println();
    }

    public synchronized boolean isFull() {
        return brett.size() == capacity;
    }

    public synchronized boolean isEmpty() {
        return brett.isEmpty();
    }

    public String toString() {

        List<Integer> s = new ArrayList<>();

        for (Hamburger burger : brett) {
           s.add(burger.nummer());
        }

        return String.join(", ", s.toString());
    }
}
