import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class StackAndQueues {

public static void main(String[] args){
    java.util.Stack<Integer> stack = new java.util.Stack<>();

    stack.push(50);
    stack.push(20);
    stack.push(15);


    System.out.println(stack);
    stack.push(35);
    System.out.println(stack);
    System.out.println(stack.pop());
    System.out.println(stack);

    Queue<Integer> queue = new LinkedList<>();
    queue.add(3);
    queue.add(10);
    queue.add(15);
    queue.add(20);

    System.out.println();

    //Peek retrieves the first element in the queue
    System.out.println("Retrieves");
    System.out.println(queue.peek());

    System.out.println();


    System.out.println("Remove");
    System.out.println(queue.remove());
    System.out.println(queue);

    //Is a resizable array that already implements the deque Interface
    Deque<Integer> deque = new ArrayDeque<>();
    deque.add(39);
    deque.addFirst(78);
    deque.addLast(100);


}
}

