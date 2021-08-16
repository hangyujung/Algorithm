package day0813;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_B1_비밀이메일 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int R=0,C=0;
		
		String s = br.readLine();
		int N = s.length();
		char[] answer = new char[N];
		
		label:for(int r=N;r>0;r--) {
			for(int c=N;c>0;c--) {
				if(r<=c&&r*c==N) {
					R=r;
					C=c;
					break label;
				}
			}
		}
		
				
		char[][] arr1  = new char[R][C];
		
		
		for(int i=0, c=0;c<C;c++) {
			for(int r=0;r<R;r++) {
				arr1[r][c] = s.charAt(i++);
			}
		}
		
		for(int i=0, r=0;r<R;r++) {
			for(int c=0;c<C;c++) {
				answer[i++]=arr1[r][c];
			}
		}
		
		for(char c :answer) {
			System.out.print(c);
		}
	}
}
