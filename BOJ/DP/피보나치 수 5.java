
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n==0) {
            System.out.println(0);
            System.exit(0);
        }
        int[] arr = new int[n+1];
        arr[0]=0;
        arr[1]=1;

        for(int i=2;i<n+1;i++){
            arr[i]=arr[i-1]+arr[i-2];
        }
        System.out.println(arr[n]);
    }
}
