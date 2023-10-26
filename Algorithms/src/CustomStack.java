
public class CustomStack {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    int pointer = -1;

    public CustomStack(){
        this(DEFAULT_SIZE);
    }
    public CustomStack(int size) {
        this.data = new int[size];
    }

    public boolean push(int item){
        if (isFull()){
            System.out.println("Stack is full");
            return false;
        }

        pointer++;
        data[pointer] = item;
        return true;
    }

    public int peek() throws StackException {
        if (isEmpty()){
            throw new StackException("Can't peek from an empty stack");
        }
        return data[pointer];
    }

    public int pop() throws StackException {
        if (isEmpty()){
            throw new StackException("Can't pop from an empty stack");
        }
//        int removed = data[pointer];
//        pointer--;
//        return removed;
        return data[pointer--];
    }

    public boolean isFull(){
        return pointer == data.length -1; //pointer is full as it reached the last index
    }

    public boolean isEmpty(){
        return pointer == -1; //It's empty as the pointer didn't change
    }


    public static void main(String[] args) throws StackException{
        CustomStack stack = new CustomStack(5);
        stack.push(5);
        stack.push(10);
        stack.push(15);
        stack.push(20);
        stack.push(25);
        stack.push(25);



        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());


    }

}
