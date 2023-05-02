import java.util.LinkedList;

public class LinkedListExp {

    public static void main(String[] args) {
        // Create a LinkedList
        LinkedList<String> colors = new LinkedList<>();

        
        colors.add("Blue");
        colors.add("Green");
        colors.add("Yellow");
        colors.add("Orange");
        colors.add("Violet");

        // Append "Red" at the end of the linked list
        colors.addLast("Red");
        System.out.println("Original Linked List: " + colors);

        // Iterate through all the elements of the linked list starting from the element 4
        System.out.print("Elements starting from index 4: ");
        for (int i = 4; i < colors.size(); i++) {
            System.out.print(colors.get(i) + " ");
        }
        System.out.println();

        // Iterate the linked list in reverse order
        System.out.print("Reverse order of the linked list: ");
        for (int i = colors.size() - 1; i >= 0; i--) {
            System.out.print(colors.get(i) + " ");
        }
        System.out.println();
    }
}
