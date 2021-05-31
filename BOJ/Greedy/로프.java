import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scan.nextInt();
        }

        Arrays.sort(arr);
        int answer =arr[0]*n;
        for(int j=1;j<arr.length;j++){
            if(answer<arr[j]*--n){
                answer=arr[j]*n;
            }
        }

        System.out.println(answer);
    }
}
