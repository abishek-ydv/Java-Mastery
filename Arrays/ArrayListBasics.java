import java.util.ArrayList;

public class ArrayListBasics {
    /* In this we are going to learn ArrayList and it's methods and solve some problems in using ArrayList Data Structures. */

    public static void main(String[] args) {
        // Creating an ArrayList of Strings
        ArrayList<String> names = new ArrayList<>();

        // Adding elements to the ArrayList
        names.add("Abhishek");
        names.add("Nidhi");
        names.add("Simran");

        // Printing the ArrayList
        System.out.println("Names: " + names);

        // Accessing elements by index
        String firstName = names.get(0);
        System.out.println("First Name: " + firstName);

        // Modifying an element
        names.set(1, "Nidhi Yadav");
        System.out.println("Modified Names: " + names);

        // Removing an element
        names.remove(2);
        System.out.println("After Removal: " + names);

        // Checking if an element exists
        boolean containsAbhishek = names.contains("Abhishek");
        System.out.println("Contains Abhishek: " + containsAbhishek);

        // Size of the ArrayList
        int size = names.size();
        System.out.println("Size of Names: " + size);

        // Iterating through the ArrayList
        System.out.println("Iterating through Names:");
        for (String name : names) {
            System.out.println(name);
        }

        // Clearing the ArrayList
        names.clear();
        System.out.println("After Clearing: " + names);
        
    }
}
