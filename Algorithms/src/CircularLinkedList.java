public class CircularLinkedList {

    private Node head;
    private Node tail;

    public CircularLinkedList() {
        this.head = null;
        this.tail = null;
    }

    private class Node {
        int value;
        Node next;

        public Node(int val) {
            this.value = val;
        }

        public Node(int val, Node next) {
            this.value = val;
            this.next = next;

        }
    }


    public void insert(int val) {
        Node node = new Node(val);

        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.next = head;
            tail = node;
        }
    }

    public void delete(int val){
        Node node = head;
        if(node == null){
            return;
        }

        if(node.value == val){
            head = head.next;
            tail = tail.next;
            return;
        }

        do{
            Node n = node.next;
            if(n.value == val){
                node.next = n.next;
                break;
            }
            node = node.next;

        } while (node != head);


    }

    public void displayList() {
        Node node = head;

        if (head != null) {
            do {
                System.out.print(node.value + " -> ");
                node = node.next;
            } while (node != head);
            System.out.println("HEAD");

        }
    }


    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.insert(23);
        list.insert(3);
        list.insert(19);
        list.insert(75);

        list.delete(3 );

        list.displayList();


    }
}
