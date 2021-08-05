import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static char[][] map;
    static int answer=Integer.MAX_VALUE;
    static char pre;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for(int i=0;i<N;i++){
            map[i]=br.readLine().toCharArray();
        }
        for(int i=0;i<=N-8;i++){
            for(int j=0;j<=M-8;j++){
                check1(i,j);
            }
        }
        sb.append(answer);
        System.out.println(sb);


    }
    static void check1(int row, int col){
        int count=0;
        pre = map[row][col];
        for(int i=row;i<row+8;i++){
            for(int j=col;j<col+8;j++){
                if(i==row&&j==col) continue;
                if(pre==map[i][j])          //전에 글자랑 같으면 틀린것
                    count++;

                    if(pre=='B') pre ='W';
                    else if(pre=='W') pre ='B';

            }
            if(pre=='B') pre ='W';
            else if(pre=='W') pre ='B';
        }
        count = Math.min(count, 64-count);
        answer=Math.min(answer, count);
    }
}
