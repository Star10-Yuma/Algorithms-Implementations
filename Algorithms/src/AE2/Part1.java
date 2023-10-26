package AE2;

public class Part1 {
    private Node tail;

    public Part1() {
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

    public void enqueue(int val){
        Node node = new Node(val);

        if (tail == null){
            tail = node;
            tail.next = tail;
        } else {
            node.next = tail.next;
            tail.next = node;
            tail = node;
        }
    }

    public int dequeue(){
        if (isEmpty()){
            System.out.println("The queue is empty");
        }

        Node head = tail.next;
        if (head == tail){
            tail = null;
        } else {
            tail.next = head.next;
        }

        return head.value;
    }

    public boolean isEmpty(){
        return tail == null;
    }

    public void displayList() {
        Node node = tail.next;

        if (isEmpty()){
            System.out.println("The queue is empty");
        }else {
            do {
                System.out.print(node.value + " -> ");
                node = node.next;
            } while (node != tail.next);
            System.out.println("END");

        }
    }


    public static void main(String[] args){
        Part1 queue = new Part1();
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);

        queue.displayList();

        queue.dequeue();
        queue.dequeue();

        queue.displayList();

    }


}
