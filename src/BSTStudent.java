public class BSTStudent {

    class Node {
        Student student;
        Node left, right;

        Node(Student student) {
            this.student = student;
        }
    }

    private Node root;

    // Insert
    public void insert(Student student) {
        root = insertRec(root, student);
    }

    private Node insertRec(Node node, Student student) {
        if (node == null) return new Node(student);
        if (student.studentId < node.student.studentId)
            node.left = insertRec(node.left, student);
        else if (student.studentId > node.student.studentId)
            node.right = insertRec(node.right, student);
        else
            System.out.println("Duplicate Student ID! Insert failed.");
        return node;
    }

    // Search
    public Student search(int id) {
        return searchRec(root, id);
    }

    private Student searchRec(Node node, int id) {
        if (node == null) return null;
        if (id == node.student.studentId) return node.student;
        return id < node.student.studentId ? searchRec(node.left, id) : searchRec(node.right, id);
    }

    // Delete
    public void delete(int id) {
        root = deleteRec(root, id);
    }

    private Node deleteRec(Node node, int id) {
        if (node == null) return null;
        if (id < node.student.studentId) node.left = deleteRec(node.left, id);
        else if (id > node.student.studentId) node.right = deleteRec(node.right, id);
        else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            Node successor = findMin(node.right);
            node.student = successor.student;
            node.right = deleteRec(node.right, successor.student.studentId);
        }
        return node;
    }

    private Node findMin(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }

    // In-order display (sorted by ID)
    public void displayInOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(Node node) {
        if (node != null) {
            inOrderRec(node.left);
            System.out.println(node.student);
            inOrderRec(node.right);
        }
    }
}