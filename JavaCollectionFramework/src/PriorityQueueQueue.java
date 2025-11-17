import java.util.*;

public class PriorityQueueQueue {

    // Custom comparator for FIFO (smallest order first)
    static class QueueComparator implements Comparator<Node> {
        public int compare(Node a, Node b) {
            return Integer.compare(a.order, b.order);
        }
    }

    // Node class to track insertion order
    static class Node {
        int value;
        int order;

        Node(int value, int order) {
            this.value = value;
            this.order = order;
        }
    }

    public static void main(String[] args) {

        PriorityQueue<Node> queue = new PriorityQueue<>(new QueueComparator());

        int order = 0;
        queue.add(new Node(10, order++));
        queue.add(new Node(20, order++));
        queue.add(new Node(30, order++));

        System.out.println("Queue using PriorityQueue:");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll().value);
        }
    }
}
