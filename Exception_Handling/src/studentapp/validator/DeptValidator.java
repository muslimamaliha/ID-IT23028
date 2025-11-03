package studentapp.validator;

public class DeptValidator {
    public static void validateDept(String dept) throws Exception {
        if (!(dept.equalsIgnoreCase("CSE") || dept.equalsIgnoreCase("EEE") || dept.equalsIgnoreCase("BBA"))) {
            throw new Exception("Invalid Department! Only CSE, EEE, or BBA allowed.");
        } else {
            System.out.println("Department is valid.");
        }
    }
}
