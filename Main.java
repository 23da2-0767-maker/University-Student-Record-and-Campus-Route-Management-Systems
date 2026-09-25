public class Main {
    public static void main(String[] args) {
        StudentLinkedList list = new StudentLinkedList();

        list.add(new Student(101, "Kamal", "IT", 75.5));
        list.add(new Student(102, "Nimal", "CS", 82.0));

        System.out.println("--- All Students ---");
        list.displayAll();

        list.update(101, "Kamal Perera", "IT", 80.0);
        System.out.println("--- After Update ---");
        list.displayAll();

        list.delete(102);
        System.out.println("--- After Delete ---");
        list.displayAll();
    }
}