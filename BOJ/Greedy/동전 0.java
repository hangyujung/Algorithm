import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int k = scan.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }


        int answer = 0;	// 사용 동전 개수
        for(int i=arr.length-1;i>=0;i--){
            if(k>=arr[i]){
                answer+=k/arr[i];
                k=k%arr[i];
            }

        }

        System.out.println(answer);
    }
}
