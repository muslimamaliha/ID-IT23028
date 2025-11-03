package studentapp;

import studentapp.validator.AgeValidator;
import studentapp.validator.DeptValidator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter your age: ");
            int age = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.print("Enter your department: ");
            String dept = sc.nextLine();

            // Validate
            AgeValidator.validateAge(age);
            DeptValidator.validateDept(dept);

            System.out.println("✅ Registration Successful!");

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
