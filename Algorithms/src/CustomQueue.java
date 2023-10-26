public class CustomQueue {

    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    int endpointer = 0;

    public CustomQueue(){
        this(DEFAULT_SIZE);
    }
    public CustomQueue(int size) {
        this.data = new int[size];
    }

    public boolean isFull(){
        return endpointer == data.length; //pointer is full as it reached the last index
    }

    public boolean isEmpty(){
        return endpointer == 0; //It's empty as the pointer didn't change
    }

    public boolean insert(int item){
        if(isFull()){
            return false;
        }
        // ++endpointer means that it increments the endpointer variable then assigns the data index however endpointer++ means it first assigns the variable to that current index in data array then it increments endpointer
        data[endpointer++] = item;
        return true;
    }

    public int remove() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is Empty");
        }

        int removed = data[0];

        //shift all elements to the left hand side so that the queue updates
        for (int i = 1; i < endpointer; i++){
            data[i - 1] = data[i];
        }
        endpointer--;
        return removed;
    }

    public int front() throws Exception{
        if (isEmpty()){
            throw new Exception("The queue is empty");
        }
        return data[0];
    }

    public void display(){
        for (int i = 0; i < endpointer; i++){
            System.out.print(data[i] + " <- ");
        }
        System.out.println("END");
    }


    public static void main(String[] args) throws Exception {
        CustomQueue queue = new CustomQueue(5);

        queue.insert(1);
        queue.insert(1);
        queue.insert(7);
        queue.insert(5);
        queue.insert(4);

        queue.display();

        queue.insert(2);

        queue.display();



    }
}
