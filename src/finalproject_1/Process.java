package finalproject_1;
//Adham Hashem
import java.io.*;
import java.util.Scanner;

public class Process {
    private LibraryData data;
    private final String FILE_NAME = "library.dat";

    public Process() {
        data = new LibraryData();
    }

    // ========== Save / Load (Binary File) ==========
    public void saveToFile() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
        out.writeObject(data);
        out.close();
    }

    public void loadFromFile() throws IOException, ClassNotFoundException {
        File f = new File(FILE_NAME);
        if (!f.exists()) return;

        ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME));
        data = (LibraryData) in.readObject();
        in.close();

        data.syncArray();
    }

    // ========== Books ==========
    public void showBooks() {
        data.syncArray();
        Book[] arr = data.getBooksArray();

        if (arr.length == 0) {
            System.out.println("No books found.");
            return;
        }

        for (Book b : arr) {
            System.out.println(b);
        }
    }

    public void addBookFromUser(Scanner input) {
        System.out.print("Book ID: ");
        String id = readText(input);

        if (findBookById(id) != null) {
            System.out.println("A book with this ID already exists.");
            return;
        }

        System.out.print("Book Name: ");
        String name = readText(input);

        System.out.print("Category: ");
        String cat = readText(input);

        // Author (Aggregation)
        System.out.print("Author Name: ");
        String aName = readText(input);

        Author a = new Author("A0", aName, "N/A", "N/A", "N/A", "N/A", 0);

        System.out.print("Price: ");
        double price = readDouble(input);

        System.out.print("Quantity: ");
        int qty = readInt(input);

        Book b = new Book(id, name, cat, a, price, qty);
        data.getBooks().add(b);
        data.syncArray();

        System.out.println("Book added.");
    }

    public void deleteBookFromUser(Scanner input) {
        System.out.print("Enter Book ID to delete: ");
        String id = readText(input);

        for (int i = 0; i < data.getBooks().size(); i++) {
            if (data.getBooks().get(i).getBookId().equalsIgnoreCase(id)) {
                data.getBooks().remove(i);
                data.syncArray();
                System.out.println("Deleted.");
                return;
            }
        }
        System.out.println("Not found.");
    }

    public void searchBookFromUser(Scanner input) {
        System.out.print("Search (ID or Name): ");
        String key = readText(input);

        Book found = searchBook(key);
        System.out.println(found != null ? found : "Not found.");
    }

    private Book findBookById(String id) {
        for (Book b : data.getBooks()) {
            if (b.getBookId().equalsIgnoreCase(id)) return b;
        }
        return null;
    }

    private Book searchBook(String key) {
        Book exactMatch = findBookById(key);
        if (exactMatch != null) return exactMatch;
        for (Book b : data.getBooks()) {
            if (b.getBookId().equalsIgnoreCase(key) ||
                b.getBookName().toLowerCase().contains(key.toLowerCase())) {
                return b;
            }
        }
        return null;
    }

    public void buyBookFromUser(Scanner input) {
        System.out.print("Enter Book ID to buy: ");
        String id = readText(input);

        Book b = findBookById(id);
        if (b == null) {
            System.out.println("Book not found.");
            return;
        }

        if (b.getQuantity() <= 0) {
            System.out.println("Out of stock.");
            return;
        }

        b.setQuantity(b.getQuantity() - 1);
        data.syncArray();
        System.out.println("Bought successfully.");
    }

    // ========== Students ==========
    public void showStudents() {
        if (data.getStudents().isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student s : data.getStudents()) {
            System.out.println(s);
        }
    }

    public void addStudentFromUser(Scanner input) {
        System.out.print("Student Name: ");
        String name = readText(input);

        System.out.print("Student University ID: ");
        String studentId = readText(input);

        for (Student student : data.getStudents()) {
            if (student.getStudentId().equalsIgnoreCase(studentId)) {
                System.out.println("A student with this university ID already exists.");
                return;
            }
        }

        Student s = new Student("S0", name, "N/A", "N/A", "N/A",
                studentId, "N/A", "2026");

        data.getStudents().add(s);
        System.out.println("Student added.");
    }

    // ========== Report ==========
    public void fullReport() {
        System.out.println("===== BOOKS =====");
        showBooks();
        System.out.println("===== STUDENTS =====");
        showStudents();
    }

    // ========== Helpers ==========
    private String readText(Scanner input) {
        String text = input.nextLine().trim();
        while (text.isEmpty()) {
            System.out.print("This field cannot be empty. Try again: ");
            text = input.nextLine().trim();
        }
        return text;
    }

    private int readInt(Scanner input) {
        while (true) {
            if (input.hasNextInt()) {
                int value = input.nextInt();
                input.nextLine();
                if (value >= 0) return value;
            } else {
                input.nextLine();
            }
            System.out.print("Enter a whole number of zero or more: ");
        }
    }

    private double readDouble(Scanner input) {
        while (true) {
            if (input.hasNextDouble()) {
                double value = input.nextDouble();
                input.nextLine();
                if (value >= 0 && !Double.isNaN(value) && !Double.isInfinite(value)) {
                    return value;
                }
            } else {
                input.nextLine();
            }
            System.out.print("Enter a valid price of zero or more: ");
        }
    }
    //Adham Hashem
}
