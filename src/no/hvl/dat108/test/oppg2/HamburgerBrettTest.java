package no.hvl.dat108.test.oppg2;

import no.hvl.dat108.oppg2.Hamburger;
import no.hvl.dat108.oppg2.HamburgerBrett;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HamburgerBrettTest {

    private HamburgerBrett<Integer> queue;

    @BeforeEach
    public void makeQueue() {
        queue = new HamburgerBrett<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
    }

    @Test
    public void printTest() {
        queue.print();
    }

    @Test
    public void enqueueTest() {
       assertEquals(3,queue.getLengde());
       queue.enqueue(5);
       assertEquals(4,queue.getLengde());

       assertNotEquals(4,queue.peek());
       assertEquals(1,queue.peek());
    }

    @Test
    public void dequeueTest() {
        assertEquals(1, queue.dequeue());
        assertNotEquals(3, queue.dequeue());
        assertNotNull(queue.peek());
    }
}
