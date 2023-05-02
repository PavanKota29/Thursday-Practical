import java.util.ArrayList;

public class ArrayListExp {

    public static void main(String[] args) {
        // Create an ArrayList to store vehicle names
        ArrayList<String> vehicles = new ArrayList<>();

        // Add some elements to the ArrayList
        vehicles.add("Honda Civic");
        vehicles.add("Maruti Suzuki Swift");
        vehicles.add("Toyota Fortuner");
        vehicles.add("Hyundai Verna");
        vehicles.add("Mahindra Scorpio");
        vehicles.add("Jeep Compass");
        vehicles.add("Ford EcoSport");
        vehicles.add("Renault Duster");
        vehicles.add("Kia Seltos");
        vehicles.add("Volkswagen Polo");
        System.out.println("Original ArrayList: " + vehicles);

        // Iterate through the ArrayList and print the elements
        System.out.print("Elements of the ArrayList: ");
        for (String vehicle : vehicles) {
            System.out.print(vehicle + " ");
        }
        System.out.println();

        // Insert an element at the start and end of the ArrayList
        vehicles.add(0, "BMW X1");
        vehicles.add("MG Hector");
        System.out.println("ArrayList after inserting elements: " + vehicles);

        // Retrieve an element at index number 4
        String elementAtIndex4 = vehicles.get(4);
        System.out.println("Element at index number 4: " + elementAtIndex4);

        // Update the element at index number 7 with vehicle name XUV300
        vehicles.set(7, "Mahindra XUV300");
        System.out.println("ArrayList after updating element at index number 7: " + vehicles);

        // Search for the element "verna"
        if (vehicles.contains("Hyundai Verna")) {
            System.out.println("Found the vehicle!");
        } else {
            System.out.println("Not found.");
        }

        // Copy the ArrayList to a new ArrayList
        ArrayList<String> newVehicles = new ArrayList<>(vehicles);
        System.out.println("New ArrayList: " + newVehicles);
    }
}
