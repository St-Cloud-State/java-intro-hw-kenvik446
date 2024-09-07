import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class MyMain {

    // Method to store persons from input stream to linked list
    public static void store(InputStream inputStream, LinkedList<Person> linkedList) {
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            String[] data = scanner.nextLine().split(",");
            if (data.length == 3) {
                Person person = new Person(data[0].trim(), data[1].trim(), data[2].trim());
                linkedList.add(person);
            }
        }
        scanner.close();
    }

    // Method to display persons from linked list to output stream
    public static void display(PrintStream outputStream, LinkedList<Person> linkedList) {
        for (Person person : linkedList) {
            outputStream.println(person.toString());
        }
    }

    // Method to find person by id in linked list
    public static int find(String sid, LinkedList<Person> linkedList) {
        for (int i = 0; i < linkedList.size(); i++) {
            if (linkedList.get(i).getId().equals(sid)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LinkedList<Person> peopleList = new LinkedList<>();
        Scanner userInputScanner = new Scanner(System.in);

        // Ask the user for the file name
        System.out.print("Please enter the name of the data file: ");
        String fileName = userInputScanner.nextLine();

        // Try to read from the file and store persons in the linked list
        try (InputStream inputStream = new FileInputStream(fileName)) {
            store(inputStream, peopleList);
        } catch (FileNotFoundException e) {
            System.err.println("Data file not found: " + fileName);
            return;
        } catch (IOException e) {
            System.err.println("Error reading the data file: " + e.getMessage());
            return;
        }

        // Display persons to console
        System.out.println("\nDisplaying all persons in the list:");
        display(System.out, peopleList);

        // Find persons by id
        String searchId1 = "12345";
        String searchId2 = "00000";

        System.out.println("\nFinding person with ID: " + searchId1);
        int index1 = find(searchId1, peopleList);
        System.out.println("Person found at index: " + index1);

        System.out.println("\nFinding person with ID: " + searchId2);
        int index2 = find(searchId2, peopleList);
        System.out.println("Person found at index: " + index2);
        
        userInputScanner.close();
    }
}