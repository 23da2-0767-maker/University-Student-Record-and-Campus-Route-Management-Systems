/**
 * ServiceQueue.java
 * Member 2 - Queue implementation
 * Purpose: Manage student service requests in the order they arrive (FIFO - First In First Out).
 */
public class ServiceQueue {

    // Node class for our custom queue (linked-list based queue)
    private class Node {
        String request;   // e.g. "S001 - Transcript Request"
        Node next;

        Node(String request) {
            this.request = request;
        }
    }

    private Node front;    // first element (next to be processed)
    private Node rear;     // last element (most recently added)
    private int size;

    public ServiceQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    // Add a new service request to the queue (Menu Option 5)
    public void enqueue(String request) {
        Node newNode = new Node(request);
        if (rear == null) {
            // queue was empty
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        System.out.println("Service request added: " + request);
    }

    // Process (remove) the next request in line (Menu Option 6)
    public String dequeue() {
        if (isEmpty()) {
            System.out.println("No service requests to process.");
            return null;
        }
        String request = front.request;
        front = front.next;
        if (front == null) {
            rear = null; // queue became empty
        }
        size--;
        System.out.println("Processing request: " + request);
        return request;
    }

    // Peek at the next request without removing it
    public String peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return null;
        }
        return front.request;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int getSize() {
        return size;
    }

    // Display all pending requests
    public void displayAll() {
        if (isEmpty()) {
            System.out.println("No pending service requests.");
            return;
        }
        System.out.println("----- Pending Service Requests (arrival order) -----");
        Node current = front;
        int count = 1;
        while (current != null) {
            System.out.println(count + ". " + current.request);
            current = current.next;
            count++;
        }
        System.out.println("-----------------------------------------------------");
    }
}