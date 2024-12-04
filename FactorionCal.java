import java.util.Scanner;
public class FactorionCal {

//function to cal factorial
public static int factorial(int digit) 
{
 int fact=1;
for(int j=1; j<=digit ; j++)
{  
   fact*=j;
}
return fact;
}

public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

System.out.println("Enter the range : ");
int s = sc.nextInt();
int e = sc.nextInt();
int count=0;

for(int i =s ; i<=e; i++)
{
 int sum=0,temp=i;

while(temp>0)
{
int digit = temp % 10;
sum = sum+ factorial(digit);
temp = temp/10;
}
if(sum==i)
    {  
      count++; 
     }
}
System.out.println("Number of factorion within range : "+count);
sc.close();
}
}
