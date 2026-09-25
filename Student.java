public class Student {
    int id;
    String name;
    String programme;
    double marks;

    Student(int id, String name, String programme, double marks) {
        this.id = id;
        this.name = name;
        this.programme = programme;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Programme: " + programme + ", Marks: " + marks;
    }
}