package no.hvl.dat108.oppg2;

public class Node<T> {
    T data;
    Node next;

    public Node() {}

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}
