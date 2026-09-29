import java.util.*;

public class Main {
    static CampusGraph campus = new CampusGraph();
    static Scanner sc = new Scanner(System.in);

    static String readText(String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = sc.nextLine().trim();
            if (input.isEmpty()) System.out.println("Input cannot be empty. Try again.");
        } while (input.isEmpty());
        return input;
    }

    public static void main(String[] args) {
        campus.loadSampleData();   // demo-ku sample data (venda na remove pannalam)

        while (true) {
            System.out.println("\n=== CAMPUS MENU ===");
            System.out.println("10. Add Campus Location");
            System.out.println("11. Remove Campus Location");
            System.out.println("12. Add Campus Connection/Road");
            System.out.println("13. Remove Campus Connection/Road");
            System.out.println("14. Display Campus Connections");
            System.out.println("15. Traverse using BFS/DFS");
            System.out.println("16. Exit");
            System.out.print("Enter choice: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            if (choice == 16) {
                System.out.println("Bye!");
                break;
            }

            switch (choice) {
                case 10 -> campus.addLocation(readText("Enter location name: "));
                case 11 -> campus.removeLocation(readText("Enter location to remove: "));
                case 12 -> {
                    String a = readText("Enter first location: ");
                    String b = readText("Enter second location: ");
                    campus.addConnection(a, b);
                }
                case 13 -> {
                    String a = readText("Enter first location: ");
                    String b = readText("Enter second location: ");
                    campus.removeConnection(a, b);
                }
                case 14 -> {
                    campus.displayNetwork();
                    campus.displayNeighbours(readText("Show neighbours of: "));
                }
                case 15 -> {
                    String start = readText("Enter start location: ");
                    campus.bfs(start);
                    campus.dfs(start);
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}