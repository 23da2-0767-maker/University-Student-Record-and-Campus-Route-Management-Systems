public class HashTable {
    private static final int SIZE = 101;
    private Student[] table;

    public HashTable() {
        table = new Student[SIZE];
    }

    private int hash(int id) {
        return id % SIZE;
    }

    public void insert(Student student) {
        int index = hash(student.id);
        int originalIndex = index;
        while (table[index] != null) {
            if (table[index].id == student.id) {
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

    public Student search(int id) {
        int index = hash(id);
        int originalIndex = index;
        while (table[index] != null) {
            if (table[index].id == id) return table[index];
            index = (index + 1) % SIZE;
            if (index == originalIndex) break;
        }
        return null;
    }

    public void delete(int id) {
        int index = hash(id);
        int originalIndex = index;
        while (table[index] != null) {
            if (table[index].id == id) {
                table[index] = null;
                return;
            }
            index = (index + 1) % SIZE;
            if (index == originalIndex) break;
        }
    }
}