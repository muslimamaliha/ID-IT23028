package studentapp.validator;

public class AgeValidator {
    public static void validateAge(int age) throws Exception {
        if (age < 18) {
            throw new Exception("Age must be 18 or above!");
        } else if (age > 60) {
            throw new Exception("Age must be 60 or below!");
        } else {
            System.out.println("Age is valid.");
        }
    }
}
