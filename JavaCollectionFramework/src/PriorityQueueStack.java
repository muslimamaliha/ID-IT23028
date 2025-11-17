import java.util.*;

public class PriorityQueueStack {

    // Comparator for LIFO (largest order first)
    static class StackComparator implements Comparator<Node> {
        public int compare(Node a, Node b) {
            return Integer.compare(b.order, a.order);
        }
    }

    static class Node {
        int value;
        int order;
        Node(int value, int order) {
            this.value = value;
            this.order = order;
        }
    }

    public static void main(String[] args) {

        PriorityQueue<Node> stack = new PriorityQueue<>(new StackComparator());

        int order = 0;
        stack.add(new Node(10, order++));
        stack.add(new Node(20, order++));
        stack.add(new Node(30, order++));

        System.out.println("Stack using PriorityQueue:");
        while (!stack.isEmpty()) {
            System.out.println(stack.poll().value);
        }
    }
}
