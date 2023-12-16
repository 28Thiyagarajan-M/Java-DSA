package LinkedList;

public class LinkedList {

    static class Node {
        Node next;
        int value;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    Node head;
    Node tail;

    int size;

    LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void insertAtTheBeginning(int val) {
        Node node = new Node(val);

        if (size == 0) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    public void insertAtTheEnd(int val) {
        Node node = new Node(val);

        if (size == 0) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void removeAtTheBeginning() {
        if (size == 0) {
            System.out.println("Linked List is empty. Delete operation can't be done.");
        } else {
            head = head.next;
        }
        size--;
    }

    public void removeAtTheEnd() {
        if (size == 0) {
            System.out.println("Linked List is empty. Delete operation can't be done.");
        } else {
            Node temp = head;

            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;

            size--;
        }

    }

    public void findMiddleValue() {

        if (size == 0) {
            System.out.println("Linked List is empty. Can't find middle.");
            return;
        }
        Node n1 = head;
        Node n2 = head;

        while (n2 != null && n2.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
        }
        System.out.println("Middle element : " + n1.value);
    }


    public void updateHeadNode(int val) {
        if (size == 0) {
            System.out.println("Linked List is empty.");
            return;
        }
        head.value = val;
    }

    public void updateTailNode(int val) {
        if (size == 0) {
            System.out.println("Linked List is empty.");
            return;
        }
        tail.value = val;
    }


    public void getHeadValue() {
        if (size == 0) {
            System.out.println("Linked List is Empty.");
            return;
        }

        System.out.println(head.value);
    }

    public void getTailValue() {
        if (size == 0) {
            System.out.println("Linked List is Empty.");
            return;
        }

        System.out.println(tail.value);
    }

    public void updateAtGivenIndex(int val, int index){
        if(index < 0 || index >= size)
        {
            return;
        }else if (index == 0) {
            updateHeadNode(val);
        }else if (index == size-1){
            updateTailNode(val);
        }else{
            Node temp = head;
            int currentIndex = 0;
            while(currentIndex != index){
                temp = temp.next;
                currentIndex++;
            }

            temp.value = val;

        }

    }

    public void insertAtGivenIndex(int val, int index) {
        if(index < 0 || index > size ){
            return;
        }else if (index == 0) {
            insertAtTheBeginning(val);
        } else if (index == size) {
            insertAtTheEnd(val);
        } else {
            Node temp = head;
            Node node = new Node(val);
            int currentPosition = 0;

            while (currentPosition != index - 1) {
                temp = temp.next;
                currentPosition++;
            }

            node.next = temp.next;
            temp.next = node;

            size++;
        }

    }
    public void removeAtPosition(int index){

        if(index < 0 || index > size ){
            return;
        }else if(index == 0){
            removeAtTheBeginning();
            return;
        }else if(index == size){
            removeAtTheEnd();
            return;
        }else{
            Node temp = head;
            int currentIndex = 0;
            while(currentIndex != index-1){
                temp = temp.next;
                currentIndex++;
            }

            temp.next = temp.next.next;
            size--;

        }
    }



    public void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }

        System.out.println("\nLinked List Size  : " + size);
    }



    public static void main(String[] args) {

        LinkedList ll = new LinkedList();

        ll.insertAtTheBeginning(1);

        ll.insertAtTheBeginning(2);

        ll.insertAtTheEnd(0);

        ll.display();

        ll.insertAtTheBeginning(3);

        ll.display();

        ll.removeAtTheBeginning();

        ll.display();

        ll.removeAtTheEnd();

        ll.display();

        ll.insertAtTheEnd(0);

        ll.display();

        ll.findMiddleValue();


        ll.updateTailNode(3);

        ll.display();

        ll.getTailValue();

        ll.insertAtGivenIndex(10, 1);

        ll.display();
    }


}
