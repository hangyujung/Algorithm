import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        for (int i = 0; i < t; i++) {
            int m = scan.nextInt();
            int[][] mans = new int[m][2];
            int answer =0;
            for (int j = 0; j < m; j++) {
                mans[j][0] = scan.nextInt();  //서류성적 입력
                mans[j][1] = scan.nextInt();  //면접성적 입력
            }
            Arrays.sort(mans, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0]-o2[0];
                }
            });

            int min=mans[0][1];
            for (int j = 0; j < m; j++) {
                if (mans[j][1] <= min) {   //앞등수사람보다 면접은 잘봄
                    answer++;
                    min=mans[j][1];
                }
            }
            System.out.println(answer);

        }  // 다시 처음 반복문으로
    }
}

