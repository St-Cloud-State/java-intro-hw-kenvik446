import java.io.*;
import java.util.Scanner;

public class MyMain {
    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);

        // Ask the user for the file name
        System.out.print("Please enter the name of the data file: ");
        String fileName = userInputScanner.nextLine();

        // Instantiate the PersonList object
        PersonList personList = new PersonList();

        // Try to read from the file and store persons in the PersonList
        try (InputStream inputStream = new FileInputStream(fileName)) {
            personList.store(inputStream);
        } catch (FileNotFoundException e) {
            System.err.println("Data file not found: " + fileName);
            return;
        } catch (IOException e) {
            System.err.println("Error reading the data file: " + e.getMessage());
            return;
        }

        // Display persons to console
        System.out.println("\nDisplaying all persons in the list:");
        personList.display(System.out);

        // Find persons by id
        String searchId1 = "12345";
        String searchId2 = "00000";

        System.out.println("\nFinding person with ID: " + searchId1);
        int index1 = personList.find(searchId1);
        System.out.println("Person found at index: " + index1);

        System.out.println("\nFinding person with ID: " + searchId2);
        int index2 = personList.find(searchId2);
        System.out.println("Person found at index: " + index2);

        userInputScanner.close();
    }
}
