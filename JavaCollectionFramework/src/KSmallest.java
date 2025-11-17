import java.util.Scanner;
import java.util.Arrays;

public class KSmallest {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        System.out.println("Enter K (position): ");
        int k = sc.nextInt();
        System.out.println(k+"th smallest element in the given array is: "+arr[k-1]);

        sc.close();
    }
}
