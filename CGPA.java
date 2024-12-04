import java.util.Scanner;
public class CGPA {
 public static void main(String[] args) {
  
  Scanner sc = new Scanner(System.in);
   int n , totalCredit=0 ;
double totalGrade = 0;
System.out.print
("Enter number of total subject : ");
   n = sc.nextInt();
   for(int  i=1 ; i<=n ; i++)
   {
     System.out.println("Subject "+i+ " : ");
     System.out.println("Enter grade point : ");
     double gradePoint = sc.nextDouble();

     System.out.println("Enter credit : ");
     int credit  = sc.nextInt();
     
     totalGrade += gradePoint * credit ;
     totalCredit += credit ;
     }

   double cgpa = totalGrade / totalCredit ;

  if (cgpa == 4.00)
   { System.out.printf("Letter Grade( A+) , marks(90-100) and cgpa is : %.2f%n ",cgpa); }
  else if (cgpa>=3.75 && cgpa<=3.99 )
   { System.out.printf("Letter Grade( A) , marks(80-89) and cgpa is : %.2f %n",cgpa); }
else if (cgpa>=3.50 && cgpa<=3.74 )
   { System.out.printf("Letter Grade( A-) , marks(75-79) and cgpa is : %.2f%n ",cgpa); }
else if (cgpa>=3.25 && cgpa<=3.49 )
   { System.out.printf("Letter Grade( B+) , marks(70-74) and cgpa is : %.2f%n ",cgpa); }
else if (cgpa>=3.00 && cgpa<=3.24 )
   { System.out.printf("Letter Grade( B) , marks(65-69) and cgpa is : %.2f%n ",cgpa); }
else if (cgpa>=2.75 && cgpa<=2.99 )
   { System.out.printf("Letter Grade( B-) , marks(60-64) and cgpa is : %.2f %n",cgpa); }
else if (cgpa>=2.50 && cgpa<=2.74 )
   { System.out.printf("Letter Grade( C+) , marks(55-59) and cgpa is : %.2f%n ",cgpa); }
else if (cgpa>=3.25 && cgpa<=2.49 )
   { System.out.printf("Letter Grade( C) , marks(50-54) and cgpa is : %.2f%n ",cgpa); }
else if (cgpa>=2.00 && cgpa<=2.24 )
   { System.out.printf("Letter Grade( D) , marks(40-49) and cgpa is : %.2f%n ",cgpa); }
else
   { System.out.printf("Letter Grade( F) , marks(Below 40) and cgpa is : %.2f%n ",cgpa); }

sc.close();
}

}
