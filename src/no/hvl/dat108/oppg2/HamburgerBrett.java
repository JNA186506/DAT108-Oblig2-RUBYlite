package no.hvl.dat108.oppg2;

public class HamburgerBrett<T> extends Node<T> {

   private Node<T> front, tail;
   private int lengde;

   public HamburgerBrett() {
       this.front = this.tail = null;
       this.lengde = 0;
   }

   public int getLengde() {
       return this.lengde;
   }

  public void enqueue(T data) {
       lengde++;
       Node newNode = new Node(data);

       if (tail == null) {
           front = tail = newNode;
       }

       tail.next = newNode;
       tail = newNode;
  }

    public T dequeue() {

       if (front.data == null) return null;

       T returnData = front.data;
       front = front.next;

       if (front.data == null) {
           tail = null;
       }

       lengde--;

       return returnData;
    }

    public T peek() {
       return front.data;
    }

    public void print() {
       Node temp = front;

       while (temp != null) {
           System.out.print(temp.data + " ");
           temp = temp.next;
       }
    }

}
