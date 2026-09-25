/**
 * ActionStack.java
 * Member 2 - Stack implementation
 * Purpose: Track recent actions (Add/Update/Delete) done on student records.
 * This acts like an "undo/history" feature using LIFO (Last In First Out).
 */
public class ActionStack {

    // Node class for our custom stack (linked-list based stack)
    private class Node {
        String action;   // e.g. "Added student S001"
        Node next;

        Node(String action) {
            this.action = action;
        }
    }

    private Node top;      // points to the top of the stack
    private int size;      // keeps track of how many actions are stored

    public ActionStack() {
        top = null;
        size = 0;
    }

    // Push a new action onto the stack
    public void push(String action) {
        Node newNode = new Node(action);
        newNode.next = top;
        top = newNode;
        size++;
        System.out.println("[LOG] Action recorded: " + action);
    }

    // Pop the most recent action (used for undo)
    public String pop() {
        if (isEmpty()) {
            System.out.println("No recent actions to undo.");
            return null;
        }
        String action = top.action;
        top = top.next;
        size--;
        return action;
    }

    // Peek at the most recent action without removing it
    public String peek() {
        if (isEmpty()) {
            System.out.println("No actions recorded yet.");
            return null;
        }
        return top.action;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int getSize() {
        return size;
    }

    // Display all recent actions (Menu Option 7)
    public void displayAll() {
        if (isEmpty()) {
            System.out.println("No recent actions to display.");
            return;
        }
        System.out.println("----- Recent Actions (most recent first) -----");
        Node current = top;
        int count = 1;
        while (current != null) {
            System.out.println(count + ". " + current.action);
            current = current.next;
            count++;
        }
        System.out.println("-----------------------------------------------");
    }
}