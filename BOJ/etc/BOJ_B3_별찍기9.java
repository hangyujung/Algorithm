

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_B3_별찍기9 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int n=0;n<N-1;n++) {
			for(int a=0;a<n;a++) {
				System.out.print(" ");
			}
			for(int s=0;s<2*N-1-2*n;s++) {
				System.out.print("*");
			}

			System.out.println();
		}
		for(int n=0;n<N;n++) {
			for(int a=0;a<N-(n+1);a++) {
				System.out.print(" ");
			}
			for(int s=0;s<2*n+1;s++) {
				System.out.print("*");
			}
		
			System.out.println();
		}
	}
}
