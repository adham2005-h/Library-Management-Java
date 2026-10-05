package finalproject_1;
//Adham Hashem
import java.io.Serializable;

public class Book implements Interfaces, Serializable {
    private String bookId;
    private String bookName;
    private String category;
    private Author author; // Aggregation
    private double price;
    private int quantity;

    public Book() {
    }

    public Book(String bookId, String bookName, String category, Author author,double price, int quantity) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.category = category;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    public Author getAuthor() {
        return author; 
    }
    public void setAuthor(Author author) { 
        this.author = author; 
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    @Override
    public void printDetails() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Book{" +
               "ID=" + bookId +", Name=" + bookName +", Category=" + category +
               ", Author=" + (author != null ? author.getName() : "N/A") +
               ", Price=" + price +
               ", Qty=" + quantity +
               "}";
    }
    //Adham Hashem
}