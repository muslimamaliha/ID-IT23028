import java.util.Scanner;

class scannerLab
{
 public static void main(String[] args) 
{
    Scanner scanner = new Scanner(System.in);
      
        for(int i=1; i<=10; i++)
          {
                 int number = scanner.nextInt();
                 System.out.println(number);
          }
   scanner.close();
 }
}