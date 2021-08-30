


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//시간제한: 초
public class BOJ_B3_별찍기7 {
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		
		for(int i=0;i<N;i++) {
			for(int s=0;s<N-1-i;s++) {
				System.out.print(" ");
			}
			for(int p=0;p<2*i+1;p++) {
				System.out.print("*");
			}
			
			System.out.println();
		}

		for(int i=0;i<N-1;i++) {
			for(int s=0;s<i+1;s++) {
				System.out.print(" ");
			}
			for(int p=0;p<N*2-3-2*i;p++) {
				System.out.print("*");
			}
		
			System.out.println();
		}
		
	}
}
