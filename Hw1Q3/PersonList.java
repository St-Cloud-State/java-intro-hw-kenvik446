import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class PersonList {
    private LinkedList<Person> peopleList;

    // Constructor
    public PersonList() {
        peopleList = new LinkedList<>();
    }

    // Method to store persons from input stream to linked list
    public void store(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            String[] data = scanner.nextLine().split(",");
            if (data.length == 3) {
                Person person = new Person(data[0].trim(), data[1].trim(), data[2].trim());
                peopleList.add(person);
            }
        }
        scanner.close();
    }

    // Method to display persons from linked list to output stream
    public void display(PrintStream outputStream) {
        for (Person person : peopleList) {
            outputStream.println(person.toString());
        }
    }

    // Method to find person by id in linked list
    public int find(String sid) {
        for (int i = 0; i < peopleList.size(); i++) {
            if (peopleList.get(i).getId().equals(sid)) {
                return i;
            }
        }
        return -1;
    }
}
