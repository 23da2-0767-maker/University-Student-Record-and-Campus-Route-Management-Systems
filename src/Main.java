import java.util.Scanner;

/**
 * Main.java
 * Member 2 Contribution - Menu-driven console interface
 * Handles Menu Options 5, 6, 7 (Queue and Stack operations)
 * Other options are placeholders to be integrated with Member 1, 3, and 4's code.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ActionStack actionStack = new ActionStack();
        ServiceQueue serviceQueue = new ServiceQueue();

        int choice = -1;

        while (choice != 16) {
            System.out.println("\n===== University Student Record and Campus Route Management System =====");
            System.out.println("1. Add Student Record");
            System.out.println("2. Update Student Record");
            System.out.println("3. Delete Student Record");
            System.out.println("4. Display All Records using Linked List");
            System.out.println("5. Add Service Request to Queue");
            System.out.println("6. Process Next Service Request");
            System.out.println("7. Display Recent Actions using Stack");
            System.out.println("8. Display Students using BST/AVL");
            System.out.println("9. Search Student using Hashing");
            System.out.println("10. Add Campus Location");
            System.out.println("11. Remove Campus Location");
            System.out.println("12. Add Campus Connection/Road");
            System.out.println("13. Remove Campus Connection/Road");
            System.out.println("14. Display Campus Connections");
            System.out.println("15. Traverse Campus Locations using BFS or DFS");
            System.out.println("16. Exit");
            System.out.print("Enter your choice: ");

            // Input validation - make sure user enters a number
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number between 1 and 16.");
                scanner.next(); // clear the invalid input
                continue;
            }

            choice = scanner.nextInt();
            scanner.nextLine(); // consume leftover newline

            switch (choice) {

                case 5:
                    // Add Service Request to Queue
                    System.out.print("Enter Student ID: ");
                    String studentId = scanner.nextLine().trim();

                    if (studentId.isEmpty()) {
                        System.out.println("Error: Student ID cannot be empty.");
                        break;
                    }

                    System.out.print("Enter Request Description (e.g. Transcript Request): ");
                    String description = scanner.nextLine().trim();

                    if (description.isEmpty()) {
                        System.out.println("Error: Request description cannot be empty.");
                        break;
                    }

                    String fullRequest = studentId + " - " + description;
                    serviceQueue.enqueue(fullRequest);
                    actionStack.push("Service request added: " + fullRequest);
                    break;

                case 6:
                    // Process Next Service Request
                    if (serviceQueue.isEmpty()) {
                        System.out.println("No service requests in the queue to process.");
                    } else {
                        String processed = serviceQueue.dequeue();
                        actionStack.push("Processed request: " + processed);
                    }
                    break;

                case 7:
                    // Display Recent Actions using Stack
                    actionStack.displayAll();
                    break;

                case 1: case 2: case 3: case 4:
                case 8: case 9: case 10: case 11:
                case 12: case 13: case 14: case 15:
                    System.out.println("This feature will be integrated with other team members' modules.");
                    break;

                case 16:
                    System.out.println("Exiting system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please select a number between 1 and 16.");
            }
        }

        scanner.close();
    }
}