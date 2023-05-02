import java.util.HashMap;
import java.util.Map;

public class HashMapExp{

    public static void main(String[] args) {
        // Create a HashMap to store student details
        Map<Integer, String> students = new HashMap<>();

        students.put(101, "XYZ");
        students.put(102, "ABC");
        students.put(103, "PQR");
        students.put(104, "Pavan");
        students.put(105, "Viju");

        // Check if the HashMap contains the mapping for key 105
        if (students.containsKey(105)) {
            System.out.println("HashMap contains the mapping for key 105.");
        } else {
            System.out.println("HashMap does not contain the mapping for key 105.");
        }

        // Count the number of key-value mappings in the HashMap
        int size = students.size();
        System.out.println("Number of key-value mappings in the HashMap: " + size);

        // Copy the mappings from the HashMap to another HashMap
        Map<Integer, String> newStudents = new HashMap<>(students);
        System.out.println("New HashMap: " + newStudents);
    }
}
