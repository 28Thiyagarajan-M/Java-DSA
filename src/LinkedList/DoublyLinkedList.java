package LinkedList;

public class DoublyLinkedList {
    private Node head;
    int size;

    DoublyLinkedList(){
        this.size = 0;
    }

    private static class Node {
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        node.prev = null;

        if (head != null) {
            head.prev = node;
        }

        head = node;
        size++;
    }

    public void insertLast(int val) {
        Node node = new Node(val);

        if (head == null) {
            head = node;
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = node;
        node.prev = temp;
        size++;
    }

    public void insert(int val, int index) {
        if (index == 0) {
            insertFirst(val);
            return;
        }else if(size == index){
            insertLast(val);
            return;
        }

        Node temp = head;
        for (int i = 1; i < index-1; i++) {
            temp = temp.next;
        }

        Node node = new Node(val, temp.next, temp);
        temp.next.prev = node;
        temp.next = node;
        size++;
    }

    public void insertAfter(int aft, int val) {
        Node p = find(aft);

        if (p == null)
            System.out.println("Doesn't Exist!!");

        Node node = new Node(val);

        node.prev = p;
        node.next = p.next;

        p.next.prev = node;
        p.next = node;
        size++;
    }

    public Node find(int aft) {
        Node node = head;

        while (node != null) {
            if (node.val == aft)
                return node;
            node = node.next;
        }

        return null;
    }

    public void removeFirstElement() {
        if (head == null) return;
        head = head.next;
        head.next.prev = null;
        size--;
    }

    public void removeLastElement() {
        Node temp = head;

        while(temp.next.next != null){
            temp = temp.next;
        }

        temp.next = null;
        size--;


    }

    public void display() {
        Node node = head;
        Node last = null;

        while (node != null) {
            System.out.print(node.val + " -> ");
            last = node;
            node = node.next;
        }

        System.out.println("End");

//        while (last != null) {
//            System.out.print(last.val + " -> ");
//            last = last.prev;
//        }
//        System.out.println("Start");
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.insertFirst(5);
        dll.insertFirst(6);
        dll.insertFirst(7);
        dll.insertFirst(8);
        dll.display();

        dll.insertLast(3);

        dll.display();

        dll.insertAfter(5,4);

        dll.display();

        dll.insert(2,6);

        dll.display();

        dll.removeLastElement();

        dll.display();


    }
}