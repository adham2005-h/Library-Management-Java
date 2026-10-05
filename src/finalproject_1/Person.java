package finalproject_1;
//Adham Hashem
import java.io.Serializable;

public abstract class Person implements Interfaces, Serializable {
    private String idNumber;
    private String name;
    private String gender;
    private String phone;
    private String address;

    public Person() {
    }

    public Person(String idNumber, String name, String gender, String phone, String address) {
        this.idNumber = idNumber;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
    }
    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" + "idNumber=" + idNumber + ", name=" + name + ", gender=" + gender + ", phone=" + phone + ", address=" + address + '}';
    }
    
    //Adham Hashem
}