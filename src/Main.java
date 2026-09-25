public class Main {
    public static void main(String[] args) {

        // Testing ActionStack
        ActionStack actionStack = new ActionStack();
        actionStack.push("Added student S001");
        actionStack.push("Updated student S002");
        actionStack.push("Deleted student S003");

        System.out.println();
        actionStack.displayAll();   // Menu Option 7

        System.out.println();

        // Testing ServiceQueue
        ServiceQueue serviceQueue = new ServiceQueue();
        serviceQueue.enqueue("S001 - Fee Payment Request");   // Menu Option 5
        serviceQueue.enqueue("S002 - Transcript Request");
        serviceQueue.enqueue("S003 - ID Card Replacement");

        System.out.println();
        serviceQueue.displayAll();

        System.out.println();
        serviceQueue.dequeue();   // Menu Option 6 - processes first one
        serviceQueue.dequeue();

        System.out.println();
        serviceQueue.displayAll();
    }
}