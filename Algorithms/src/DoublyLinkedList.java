public class DoublyLinkedList {
    private Node head;

    private class Node {
        int value;
        Node next;
        Node previous;


        public Node(int val) {
            this.value = val;
        }

        public Node(int val, Node next, Node previous) {
            this.value = val;
            this.next = next;
            this.previous = previous;
        }
    }

    public void insertFirst(int val) {
        //Creates the node then sets the head and checks that behind the node is nothing
        Node node = new Node(val);
        node.next = head;
        node.previous = null;

        //Null pointer exception to check if the head is not null then the value is set to the head
        if (head != null) {
            head.previous = node;
        }
        //sets the head to the node so now it's the first element
        head = node;


    }


    public void display() {
        //Temporary variable to reassign head and to not change the structure of the linked list
        Node tempnode = head;

        //This while loop will go through the linked list until it is at the end when the node is null meaning there is no value so the list ended
        while (tempnode != null) {
            //This will print the value of the Node that is reached every time the temp moves
            System.out.print(tempnode.value + " -> ");
            //This .next is a reference variable which points to the next Node object
            //Meaning that it will move the temp along the linked list
            tempnode = tempnode.next;
        }
        System.out.println("END");
    }

    public void insertLast(int val) {
        Node node = new Node(val);
        Node lastNode = head;
        //We prepped the node to know that after that node it should be null
        node.next = null;

        if (head == null) {
            node.previous = null;
            head = node;
            return;
        }

        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }

        //After getting the last node we add the node to after that last node so now it becomes the new last node
        lastNode.next = node;
        //The node previous that is the current last node meaning that we have become the last node
        node.previous = lastNode;


    }

    //This method takes advantage of the doubly linked list advantage of being able to go backwards to print the values in reverse
    public void displayInReverse() {
        //As we don't have a tail for this version we can make our own using a while loop to traverse to the end of the linked list and set our lastNode variable to that Node then we can create another while loop to go in reverse
        Node tempNode = head;
        Node lastNode = null;

        //This first goes through the linked list and keeps updating the lastNode variable until it reaches the last Node in the list and the lastNode variable is updated to that
        while (tempNode != null) {
            lastNode = tempNode;
            tempNode = tempNode.next;
        }

        //In this while loop it is similar as the one before how it uses the .previous Node type to keep going back the list until it reaches to null
        while (lastNode != null) {
            System.out.print(lastNode.value + " <- ");
            lastNode = lastNode.previous;
        }
        System.out.println("START");

    }

    public Node find(int value) {
        //This sets then node as head and iterates through the linked list until it finds a node which contains the value desired
        Node node = head;
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        //if not found it returns null
        return null;
    }

    //This method places a node between two nodes
    public void placeNode(int nodePlaceValue, int firstNodeValue, int secondNodeValue) {
        Node node = new Node(nodePlaceValue);

        Node firstNode = find(firstNodeValue);
        Node secondNode = find(secondNodeValue);

        if (firstNode == null || secondNode == null) {
            node = null;
            return;
        }

        //this is needed for the forward display method
        firstNode.next = node;
        secondNode.previous = node;

        //This is needed to make another pointer for the reverseDisplay as this is a doubly linked list
        node.previous = firstNode;
        node.next = secondNode;
    }


    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(8);
        //17 will be the first value in the linked list as it is set to the head
        list.insertFirst(17);
        list.insertLast(90);
        list.placeNode(69, 2, 7);

        list.display();
        System.out.println();
        list.displayInReverse();



    }
}
