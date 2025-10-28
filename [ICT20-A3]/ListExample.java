import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class ListExample {
    public static void main(String[] args) {
        // ArrayList Example
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("Avocado", "Grapes", "Pineapple", "Date"));
        arrayList.add("Apple");
        arrayList.add("Banana");

        System.out.println("Size: " + arrayList.size());
        System.out.println("ArrayList: " + arrayList);

        arrayList.remove("Grapes");
        System.out.println("ArrayList after removal: " + arrayList);
        System.out.println("Size after removal: " + arrayList.size());

        // Vector Example
        Vector<String> vector = new Vector<>();
        vector.add("Mango");
        vector.add("Orange");
        System.out.println("Vector: " + vector);
    }
}
