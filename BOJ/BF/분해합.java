import java.beans.Visibility;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n= scan.nextInt();
        int ans =0;
        for(int i=1;i<n;i++){
            int ls = linesum(i);
            if(n==(i+ls)) {
                ans = i;
                break;
            }
        }
        System.out.println(ans);
    }
    private static int linesum(int n){
        int sum=0;
        while(n>0){
            sum+=n%10;
            n=n/10;
        }
        return sum;
    }
}
