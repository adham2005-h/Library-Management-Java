package finalproject_1;
//Adham Hashem
import java.util.Scanner;

public class FinalProject_1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Process process = new Process();

        try {
            process.loadFromFile();
        } catch (Exception e) {
            System.out.println("Could not load library.dat. Check the file before running again.");
            input.close();
            return;
        }
        int choice;

        do {
            System.out.println("\n========= Library Menu =========");
            System.out.println("1) Show Books");
            System.out.println("2) Add a Book");
            System.out.println("3) Delete a Book");
            System.out.println("4) Search for a Book");
            System.out.println("5) Buy a Book");
            System.out.println("6) Show Students");
            System.out.println("7) Add a Student");
            System.out.println("8) Full Report");
            System.out.println("9) Exit");
            System.out.print("Choose: ");

            while (!input.hasNextInt()) {
                input.next();
                System.out.print("Enter a number: ");
            }
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    process.showBooks();
                    break;
                case 2:
                    process.addBookFromUser(input);
                    break;
                case 3:
                    process.deleteBookFromUser(input);
                    break;
                case 4:
                    process.searchBookFromUser(input);
                    break;
                case 5:
                    process.buyBookFromUser(input);
                    break;
                case 6:
                    process.showStudents();
                    break;
                case 7:
                    process.addStudentFromUser(input);
                    break;
                case 8:
                    process.fullReport();
                    break;
                case 9:
                    try {
                        process.saveToFile();
                        System.out.println("Saved successfully. Bye!");
                    } catch (Exception e) {
                        System.out.println("Save error: " + e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 9);

        input.close();
    }
    //Adham Hashem
}
