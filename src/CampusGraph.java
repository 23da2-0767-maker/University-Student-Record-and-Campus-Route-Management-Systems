import java.util.*;

/**
 * Member 4: Campus graph using an adjacency list.
 * Vertices = campus locations, Edges = roads/paths (undirected).
 */
public class CampusGraph {

    // Key = location name, Value = list of connected locations
    private final Map<String, List<String>> adjList = new LinkedHashMap<>();

    // Make names consistent: "library " and "LIBRARY" are the same
    private String fix(String name) {
        return name.trim().toUpperCase();
    }

    // ---------- Requirement 9: add/remove locations ----------
    public boolean addLocation(String name) {
        name = fix(name);
        if (name.isEmpty()) {
            System.out.println("Location name cannot be empty.");
            return false;
        }
        if (adjList.containsKey(name)) {
            System.out.println("Duplicate! Location already exists: " + name);
            return false;
        }
        adjList.put(name, new ArrayList<>());
        System.out.println("Location added: " + name);
        return true;
    }

    public boolean removeLocation(String name) {
        name = fix(name);
        if (!adjList.containsKey(name)) {
            System.out.println("Location not found: " + name);
            return false;
        }
        // remove this location from all neighbours' lists first
        for (String neighbour : adjList.get(name)) {
            adjList.get(neighbour).remove(name);
        }
        adjList.remove(name);
        System.out.println("Location removed: " + name);
        return true;
    }

    // ---------- Requirement 9: add/remove connections ----------
    public boolean addConnection(String a, String b) {
        a = fix(a);
        b = fix(b);
        if (!adjList.containsKey(a) || !adjList.containsKey(b)) {
            System.out.println("Both locations must exist first.");
            return false;
        }
        if (a.equals(b)) {
            System.out.println("Cannot connect a location to itself.");
            return false;
        }
        if (adjList.get(a).contains(b)) {
            System.out.println("Connection already exists: " + a + " <-> " + b);
            return false;
        }
        adjList.get(a).add(b);
        adjList.get(b).add(a);   // undirected
        System.out.println("Connection added: " + a + " <-> " + b);
        return true;
    }

    public boolean removeConnection(String a, String b) {
        a = fix(a);
        b = fix(b);
        if (!adjList.containsKey(a) || !adjList.containsKey(b)) {
            System.out.println("One or both locations do not exist.");
            return false;
        }
        if (!adjList.get(a).contains(b)) {
            System.out.println("Connection not available: " + a + " <-> " + b);
            return false;
        }
        adjList.get(a).remove(b);
        adjList.get(b).remove(a);
        System.out.println("Connection removed: " + a + " <-> " + b);
        return true;
    }

    // ---------- Requirement 10: display network ----------
    public void displayNetwork() {
        if (adjList.isEmpty()) {
            System.out.println("Campus graph is empty.");
            return;
        }
        System.out.println("\n--- Campus Network ---");
        for (Map.Entry<String, List<String>> e : adjList.entrySet()) {
            System.out.println(e.getKey() + " -> " +
                (e.getValue().isEmpty() ? "(no connections)" : e.getValue()));
        }
    }

    public void displayNeighbours(String name) {
        name = fix(name);
        if (!adjList.containsKey(name)) {
            System.out.println("Location not found: " + name);
            return;
        }
        System.out.println("Neighbours of " + name + ": " + adjList.get(name));
    }

    // ---------- Requirement 11: BFS (uses a queue) ----------
    public void bfs(String start) {
        start = fix(start);
        if (!adjList.containsKey(start)) {
            System.out.println("Start location not found: " + start);
            return;
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        visited.add(start);
        queue.add(start);

        System.out.print("BFS from " + start + ": ");
        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.print(current + " ");
            for (String n : adjList.get(current)) {
                if (!visited.contains(n)) {
                    visited.add(n);
                    queue.add(n);
                }
            }
        }
        System.out.println();
    }

    // ---------- Requirement 11: DFS (recursion) ----------
    public void dfs(String start) {
        start = fix(start);
        if (!adjList.containsKey(start)) {
            System.out.println("Start location not found: " + start);
            return;
        }
        System.out.print("DFS from " + start + ": ");
        dfsHelper(start, new HashSet<>());
        System.out.println();
    }

    private void dfsHelper(String current, Set<String> visited) {
        visited.add(current);
        System.out.print(current + " ");
        for (String n : adjList.get(current)) {
            if (!visited.contains(n)) {
                dfsHelper(n, visited);
            }
        }
    }

    // Optional: sample data so your demo is quick
    public void loadSampleData() {
        String[] places = {"Main Gate", "Library", "Canteen", "Lab Block", "Admin Office", "Hostel"};
        for (String p : places) adjList.put(fix(p), new ArrayList<>());
        addConnection("Main Gate", "Library");
        addConnection("Main Gate", "Admin Office");
        addConnection("Library", "Canteen");
        addConnection("Library", "Lab Block");
        addConnection("Canteen", "Hostel");
    }
}