package no.hvl.dat108.oppg2;

import java.util.ArrayList;
import java.util.List;

public class HamburgerBrett {

    private List<Hamburger> brett;
    private int capacity;
    private int burgerNummer;

    public HamburgerBrett(int capacity) {
        this.brett = new ArrayList<Hamburger>();
        this.capacity = capacity;
        this.burgerNummer = 0;
    }

    public void enqueue(Hamburger burger) {
        if (brett.size() < capacity) {
            brett.add(burger);
            burgerNummer++;
            return;
        }
        System.out.println("Brettet er fullt");
    }

    public Hamburger dequeue() {
        Hamburger burger = brett.getFirst();
        brett.removeFirst();
        return burger;
    }

    public Hamburger peek() {
        return brett.getFirst();
    }

    public boolean isFull() {
        return brett.size() == capacity;
    }

    public boolean isEmpty() {
        return brett.isEmpty();
    }
}
