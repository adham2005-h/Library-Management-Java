package finalproject_1;
//Adham Hashem
public class Student extends Person {
    private String studentId;
    private String specialization;
    private String enrolledDate;

    public Student() {
        super();
    }

    public Student(String idNumber, String name, String gender, String phone, String address,String studentId, String specialization, String enrolledDate) {
        super(idNumber, name, gender, phone, address);
        this.studentId = studentId;
        this.specialization = specialization;
        this.enrolledDate = enrolledDate;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getEnrolledDate() {
        return enrolledDate;
    }

    public void setEnrolledDate(String enrolledDate) {
        this.enrolledDate = enrolledDate;
    }
    
    @Override
    public void printDetails() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Student{" + super.toString() +" StudentID=" + studentId +" Spec=" + specialization +" EnrolledDate=" + enrolledDate +"}";
    }
    //Adham Hashem
}