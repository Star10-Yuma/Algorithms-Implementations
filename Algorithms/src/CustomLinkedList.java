public class CustomLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public CustomLinkedList() {
        this.size = 0;
    }

    public void insertFirst(int val) {
        //We create the first node then we set it to be the head reference variable
        Node node = new Node(val);
        node.next = head;
        //This sets the head to this node we created
        head = node;

        //If this is the only variable in the list the tail which is supposed to be in the last position of the list
        //Will also be referenced like head as there is one element
        if (tail == null) {
            tail = head;
        }
        //Increments the size variable so we can easily know the size of this list
        size++;
    }

    public void insertLast(int val) {

        //This checks if the tail is null then we have to insert a value to the list as it is empty
        //So it calls insertFirst to insert the value and starts the linked list
        if (tail == null) {
            insertFirst(val);
        }

        //This else states that if the linked list exists and the tail is not null then it sets tail to the value
        //This takes advantage of our tail reference variable to add the node at the end of the linked list
        //This is done by moving the tail using .next and setting the Node object here as the tail
        else {
            Node node = new Node(val);
            tail.next = node;
            tail = node;
        }
        size++;

    }

    public void insert(int val, int index) {

        //This checks if the index is 0 that means we just need to call the insertFirst() method to add the value at the start of the list
        if (index == 0) {
            insertFirst(val);
            return;
        }

        //If the index number is the size of the list meaning the last index it will add the value at the end
        if (index == size) {
            insertLast(val);
            return;
        }

        //If the index number is anything that is not the first or last index it will make a temp like before and set that to reference head
        Node temp = head;

        //As temp is head that means it's at index 0 so the for loop starts from 1 and increments till it reaches the index number the user requested\
        //It will also move temp along while it increments till it reaches to that index position
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        //We then create the new node we want to add with its value and the position it should be in
        Node node = new Node(val, temp.next);
        //Then we set the temp node to the node we just created to replace temp and move the rest of the elements on the right by one
        temp.next = node;

        //Increments size of the list as we added a new element
        size++;
    }

    public int deleteFirst() {
        //This obtains the current value of head
        int value = head.value;
        //Then to delete it we just move and assign head to the next node
        head = head.next;

        //If the next node is null meaning it doesn't have a value then tail is also null
        if (head == null) {
            tail = null;
        }
        size--;
        return value;
    }

    public int deleteLast() {
        //This checks if the size is 1 then we just delete the first one so head as head and tail would be in the same position
        if (size <= 1) {
            return deleteFirst();
        }

        //This returns then current last value of the linked list
        int lastValue = tail.value;
        //We create a temp to reference head
        Node temp = head;

        //We then iterate through the linked list until we reach the second last element as we started at i = 1
        for (int i = 1; i < size; i++) {
            temp = temp.next;
        }

        //We set the tail now as temp
        tail = temp;
        //Now we set the last element as null so the new tail is actually the last element in the linked list
        tail.next = null;

        //The size is decremented as we deleted an element
        size--;
        return lastValue;
    }

    //This method searches for the Node which contains the specific value
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


    public void displayList() {
        //We create a temp Node which is in the same location as the head so that we can use it instead of the head to print out all the elements in the linked list
        //We use this temp so that the head doesn't move and to prevent the linked list from restructuring
        //The temp is only a reference to the head and is only used within this method
        Node temp = head;

        //This while loop will go through the linked list until it is at the end when the node is null meaning there is no value so the list ended
        while (temp != null) {
            //This will print the value of the Node that is reached every time the temp moves
            System.out.print(temp.value + " -> ");
            //This .next is a reference variable which points to the next Node object
            //Meaning that it will move the temp along the linked list
            temp = temp.next;
        }
        System.out.println("END");
    }

    private class Node {

        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(8);
        //17 will be the first value in the linked list as it is set to the head
        list.insertFirst(17);

        //99 will be set at the last position of the linked list as it was set to tail
        list.insertLast(99);

        list.insert(100, 3);

        list.displayList();

        System.out.println(list.deleteFirst());

        list.displayList();

        System.out.println(list.deleteLast());

        list.displayList();


    }
}
