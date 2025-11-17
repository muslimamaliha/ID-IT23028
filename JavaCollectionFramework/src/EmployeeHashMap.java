import java.util.*;

public class EmployeeHashMap {

    public static void main(String[] args) {

        HashMap<Integer, String> employeeDept = new HashMap<>();

        employeeDept.put(10, "HR");
        employeeDept.put(2, "Finance");
        employeeDept.put(3, "IT");
        employeeDept.put(4, "Marketing");

        System.out.println("Employee Department Mapping:");
        for (Map.Entry<Integer, String> e : employeeDept.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
    }
}
