package Stack;

public class Stack {
    private Node top;
    private int size;

    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    Stack() {
        this.size = 0;
    }

    public void push(int value) {
        Node node = new Node(value);
        if (size == 0) {
            top = node;
        } else {
            node.next = top;
            top = node;
        }

        size++;
    }

    public void pop() {
        if (size == 0) {
            System.out.println("Stack is empty!");
        } else {
            System.out.println("Popped value : " + top.value);
            top = top.next;
            size--;
        }
    }

    public void display() {
        Node temp = top;
        System.out.println("Stack Values :");
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();

        s.push(10);
        s.push(9);
        s.push(8);
        s.push(7);
        s.push(6);
        s.push(5);

        s.pop();


        s.display();


    }
}
