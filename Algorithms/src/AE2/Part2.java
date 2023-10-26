package AE2;

public class Part2 {
        protected int[] data;
        int pointer = -1;
        private int[] frequencyNum;
        private int[] heap;
        private static int size;
    private static final int DEFAULT_SIZE = size;


    public Part2(){
            this(DEFAULT_SIZE);
        }
        public Part2(int size) {
            this.data = new int[size];
            this.frequencyNum = new int[size];
            this.heap = new int[size];
            this.size = 0;

        }

        public boolean push(int item){
            if (isFull()){
                System.out.println("Stack is full");
                return false;
            }

            pointer++;
            data[pointer] = item;
            frequencyNum[item]++;
            heap[size] = item;
            size++;
            buildMaxHeap();
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


            int item = data[pointer];
            frequencyNum[item]--;
            if (item == heap[0]){
                while (size > 0 && frequencyNum[heap[0]] == 0){
                    size--;
                    heap[0] = heap[size];
                    maxHeapify(0);
                }
            }
            pointer--;

            return item;
        }

    public int left(int i){
        return (2 * i) + 1;
    }

    public int right(int i){
        return (2 * i) + 2;
    }

    public void buildMaxHeap(){
        for (int i = (size / 2) - 1; i >= 0; i--) {
            maxHeapify(i);
        }
    }

    public void maxHeapify(int i){
        int l = left(i);
        int r = right(i);
        int largest;


        if(l < size && frequencyNum[heap[l]] > frequencyNum[heap[i]]){
            largest = l;
        } else {
            largest = i;
        }
        if (r < size && frequencyNum[heap[r]] > frequencyNum[heap[largest]]){
            largest = r;
        }
        if(largest != i){
            swap(i , largest);
            maxHeapify(largest);
        }



    }

    public void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

        public boolean isFull(){
            return pointer == data.length -1; //pointer is full as it reached the last index
        }

        public boolean isEmpty(){
            return pointer == -1; //It's empty as the pointer didn't change
        }


        public static void main(String[] args) throws StackException {
            Part2 stack = new Part2(5);
            stack.push(5);
            stack.push(10);
            stack.push(15);
            stack.push(20);

            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());


        }

    }


