

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_B3_별찍기3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int n=0;n<N;n++) {
			for(int c=0;c<n+1;c++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
