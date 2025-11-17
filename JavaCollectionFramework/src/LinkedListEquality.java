import java.util.*;

public class LinkedListEquality {

    // User-defined method to compare two LinkedLists
    public static boolean areListsEqual(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        if (l1.size() != l2.size()) {
            return false;
        }
        for (int i = 0; i < l1.size(); i++) {
            if (!l1.get(i).equals(l2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedList<Integer> l1 = new LinkedList<>();
        LinkedList<Integer> l2 = new LinkedList<>();

        System.out.print("Enter number of elements for first list: ");
        int n1 = sc.nextInt();
        System.out.println("Enter elements of first list:");
        for (int i = 0; i < n1; i++) {
            l1.add(sc.nextInt());
        }

        System.out.print("Enter number of elements for second list: ");
        int n2 = sc.nextInt();
        System.out.println("Enter elements of second list:");
        for (int i = 0; i < n2; i++) {
            l2.add(sc.nextInt());
        }

        // Compare the lists using user-defined method
        if (areListsEqual(l1, l2)) {
            System.out.println("Both LinkedLists are equal.");
        } else {
            System.out.println("LinkedLists are NOT equal.");
        }

        sc.close();
    }
}
