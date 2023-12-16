package Queue;

public class Queue {
    private Node first;
    private Node last;
    private int size;

    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    Queue() {
        this.size = 0;
    }

    public void enqueue(int value) {
        Node node = new Node(value);

        if (size == 0) {
            first = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }

        size++;
    }

    public void dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty!!");
            return;
        }
        System.out.println("Removed item : " + first.value);
        first = first.next;

        size--;
    }

    public void display() {
        Node temp = first;

        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);

        q.display();

        q.dequeue();

        q.display();


    }

}
