import java.util.ArrayList;
import java.util.Scanner;

public class PatientManagementSystem {
    // ArrayList to store user names
    private ArrayList<String> userNameList;
    // ArrayList to store user ages
    private ArrayList<Integer> userAgeList;
    // Scanner for user input
    private Scanner scanner;
    //scanner for user Ailment
    private ArrayList<String> userAilmentList;

    // Constructor to initialize userList, userAgeList, and scanner
    public PatientManagementSystem() {
        userNameList = new ArrayList<>();
        userAgeList = new ArrayList<>();
        userAilmentList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Method to insert new user data
    public void insertUserData() {
        // Prompt user to enter name
        System.out.println("Enter Patient name:");
        // Read name input from the user
        String name = scanner.nextLine();
        // Prompt user to enter age
        System.out.println("Enter age:");
        // Read age input from the user
        int age = scanner.nextInt();
        // Consume newline character
        scanner.nextLine();
        // Prompt user to ailment
        System.out.println("Enter Ailment:");
        // Read name input from the user
        String Ailment = scanner.nextLine();

        // Add name to userNameList
        userNameList.add(name);
        // Add age to userAgeList
        userAgeList.add(age);
         // Add Ailment to userAilmentList
         userAilmentList.add(Ailment);
        // Display success message
        System.out.println("\nPatient inserted successfully.");
    }

    // Method to manipulate user data
    public void manipulateUserData() {
        // Check if userList is empty
        if (userNameList.isEmpty()) {
            // If empty, display message and return
            System.out.println("Patient list is empty.");
            return;
        }

        // If not empty, display user data
        System.out.println("Patient List:");
        // Iterate over userNameList and userAgeList simultaneously
        for (int i = 0; i < userNameList.size(); i++) {
            // Display index, name, and age of each user
            System.out.println("Index: " + i + ", Name: " + userNameList.get(i) + ", Age: " + userAgeList.get(i)+", Ailment: " + userAilmentList.get(i));
        }
    }

    // Method to delete user data
    public void deleteUserData() {
        // Check if userList is empty
        if (userNameList.isEmpty()) {
            // If empty, display message and return
            System.out.println("Patient list is empty.");
            return;
        }

        // If not empty, prompt user to enter index of user to delete
        System.out.println("Enter the index of the patient to delete (0-" + (userNameList.size() - 1) + "):");
        // Read index input from the user
        int index = scanner.nextInt();
        // Consume newline character
        scanner.nextLine();

        // Check if the entered index is valid
        if (index >= 0 && index < userNameList.size()) {
            // If valid, remove user data at the specified index
            String deletedName = userNameList.remove(index);
            int deletedAge = userAgeList.remove(index);
            String deletedAilment = userAilmentList.remove(index);
            // Display success message
            System.out.println("Patient '" + deletedName + "' (Age: " + deletedAge + ") deleted successfully.");
        } else {
            // If invalid, display error message
            System.out.println("Invalid index.");
        }
    }

    // Main method
    public static void main (String[] args) {
        // Create an instance of UserManagementSystem
        PatientManagementSystem system = new PatientManagementSystem();
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        // Variable to control the loop
        boolean running = true;

        // Main loop
        while (running) {
            // Display menu options
            System.out.println("\n1. Manipulate patient data\n2. Register new patient \n3. Delete Patient data\n4. Exit");
            System.out.println("Enter your choice:");
            // Read user's choice
            int choice = scanner.nextInt();
            // Consume newline character
            scanner.nextLine();

            // Switch case to handle user's choice
            switch (choice) {
                case 1:
                    system.manipulateUserData();
                    break;
                case 2:
                    system.insertUserData();
                    break;
                case 3:
                    system.deleteUserData();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        // Close the Scanner object
        scanner.close();
    }
}
