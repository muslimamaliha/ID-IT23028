import java.util.ArrayList;
import java.util.Vector;

public class SimpleCapacityProof {
    public static void main(String[] args) {

        // ===== ArrayList =====
        ArrayList<Integer> arrayList = new ArrayList<>(4); // initial capacity 4
        System.out.println("=== ArrayList ===");
        for (int i = 1; i <= 6; i++) {
            arrayList.add(i);
            System.out.println("After adding element " + i + ", size: " + arrayList.size());
        }
        System.out.println();

        // ===== Vector =====
        Vector<Integer> vector = new Vector<>(4); // initial capacity 4
        System.out.println("=== Vector ===");
        System.out.println("Initial capacity: " + vector.capacity());
        for (int i = 1; i <= 6; i++) {
            vector.add(i);
            System.out.println("After adding element " + i + ", size: " + vector.size() + ", capacity: " + vector.capacity());
        }
    }
}
