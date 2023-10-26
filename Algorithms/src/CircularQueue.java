public class CircularQueue {

    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    int frontpointer = 0;
    int endpointer = 0;
    int size = 0;

    public CircularQueue(){
        this(DEFAULT_SIZE);
    }
    public CircularQueue(int size) {
        this.data = new int[size];
    }

    public boolean isFull(){
        return size == data.length; //pointer is full as it reached the last index
    }

    public boolean isEmpty(){
        return size == 0; //It's empty as the pointer didn't change
    }

    public boolean insert(int item){
        if(isFull()){
            return false;
        }
        // ++endpointer means that it increments the endpointer variable then assigns the data index however endpointer++ means it first assigns the variable to that current index in data array then it increments endpointer
        data[endpointer++] = item;
        endpointer = endpointer % data.length;
        size++;
        return true;
    }

    public int remove() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is Empty");
        }

        int removed = data[frontpointer++];

        frontpointer = frontpointer % data.length;
        size--;
        return removed;
    }

    public int front() throws Exception{
        if (isEmpty()){
            throw new Exception("The queue is empty");
        }
        return data[frontpointer];
    }

    public void display(){
        if (isEmpty()){
            System.out.println("The queue is empty");
        }
        int i = frontpointer;
        do{
            System.out.print(data[i] + " <- ");
            i++;
            i %= data.length;
        } while ( i != endpointer);
        System.out.println("END");
    }

    public static void main(String[] args) throws Exception {
        CircularQueue queue = new CircularQueue(5);

        queue.insert(5);
        queue.insert(10);
        queue.insert(15);
        queue.insert(20);
        queue.insert(25);

        queue.display();

        queue.remove();

        queue.display();

    }
}
