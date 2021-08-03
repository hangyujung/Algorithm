import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("input.txt"));
        Scanner scan =new Scanner(System.in);
        int N = scan.nextInt();
        int[] answer =new int[N];
        int[][] arr =new int[N][2];
        for(int i=0;i<N;i++){
            arr[i][0]=scan.nextInt();
            arr[i][1]=scan.nextInt();
        }
        for(int i=0;i<N;i++){
            int count=1;
            for(int j=0;j<N;j++){
                if(arr[i][0]<arr[j][0] && arr[i][1]<arr[j][1]){
                    count++;
                }
            }
            answer[i]=count;
        }
        for(int data:answer){
            System.out.print(data+" ");
        }
    }
}
