package finalproject_1;
//Adham Hashem
public class Author extends Person {
    private String email;
    private int noOfBooks;

    public Author() {
        super();
    }

    public Author(String idNumber, String name, String gender, String phone, String address,
                  String email, int noOfBooks) {
        super(idNumber, name, gender, phone, address);
        this.email = email;
        this.noOfBooks = noOfBooks;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNoOfBooks() {
        return noOfBooks;
    }

    public void setNoOfBooks(int noOfBooks) {
        this.noOfBooks = noOfBooks;
    }
    

    @Override
    public void printDetails() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Author{" + super.toString() +" Email=" + email +" NoOfBooks=" + noOfBooks +"}";
    }
    //Adham Hashem
}