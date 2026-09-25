public class HashTable {
    private static final int SIZE = 101; // prime number, reduces collisions
    private Student[] table;

    public HashTable() {
        table = new Student[SIZE];
    }

    private int hash(int id) {
        return id % SIZE;
    }

    // Insert using linear probing (collision handling)
    public void insert(Student student) {
        int index = hash(student.studentId);
        int originalIndex = index;
        while (table[index] != null) {
            if (table[index].studentId == student.studentId) {
                System.out.println("Duplicate ID in HashTable!");
                return;
            }
            index = (index + 1) % SIZE;
            if (index == originalIndex) {
                System.out.println("Hash table full!");
                return;
            }
        }
        table[index] = student;
    }

    // Search - O(1) average
    public Student search(int id) {
        int index = hash(id);
        int originalIndex = index;
        while (table[index] != null) {
            if (table[index].studentId == id) return table[index];
            index = (index + 1) % SIZE;
            if (index == originalIndex) break;
        }
        return null;
    }

    public void delete(int id) {
        int index = hash(id);
        int originalIndex = index;
        while (table[index] != null) {
            if (table[index].studentId == id) {
                table[index] = null;
                return;
            }
            index = (index + 1) % SIZE;
            if (index == originalIndex) break;
        }
    }
}
