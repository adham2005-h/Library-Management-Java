package finalproject_1;
//Adham Hashem
import java.io.Serializable;
import java.util.ArrayList;

public class LibraryData implements Serializable {
    private ArrayList<Book> books;
    private ArrayList<Student> students;

    // Array of objects requirement
    private Book[] booksArray;

    public LibraryData() {
        books = new ArrayList<>();
        students = new ArrayList<>();
        booksArray = new Book[0];
    }

    public ArrayList<Book> getBooks() { return books; }
    public ArrayList<Student> getStudents() { return students; }

    public Book[] getBooksArray() { return booksArray; }

    public void syncArray() {
        booksArray = books.toArray(new Book[0]);
    }
    //Adham Hashem
}