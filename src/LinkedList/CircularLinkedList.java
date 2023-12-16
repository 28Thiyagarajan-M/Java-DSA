package LinkedList;

public class CircularLinkedList {
    Node head;
    Node tail;
    int size;

    private static class Node{
        Node next;
        int value;

        Node(int value){
            this.value = value;
        }
    }

    CircularLinkedList(){
        this.size= 0;
    }

    public void insert(int value){
        Node node = new Node(value);

        if(size == 0){
            head = node;
            tail = node;
        }else{
          tail.next = node;
          node.next = head;
          tail = node;
        }
        size++;
    }

    public void remove(){
        if(size == 0){
            System.out.println("Empty!");
        }
        tail.next = head.next;
        head = tail.next;
    }

    public void display(){
        Node temp = head;
        System.out.println("size :"+size);
        while(temp.next != head){
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.print(temp.value);

    }

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();

        cll.insert(1);
        cll.insert(2);
        cll.insert(3);
        cll.insert(4);
        cll.insert(5);

        cll.display();


    }
}
