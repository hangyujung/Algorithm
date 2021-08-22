package day0820;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BOJ_B1_단어공부 {
	static int answer_index;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int[] answer=new int[26];
		char carr[] = br.readLine().toCharArray();		
		for(int i=0;i<carr.length;i++) {
			if(carr[i]>=97) {
				carr[i]-=32;
			}
			answer[carr[i]-65]++;
		}
		int max=0;
		int max2=0;
		for(int i=0;i<answer.length;i++) {
			if(max<answer[i]) {
				max=answer[i];
				answer_index=i;
			}
			else if(max==answer[i]) {
				max2 = answer[i];
			}
		}
		if(max!=max2) {
			char c= (char) (65+answer_index);
			System.out.println(c);
		}else {
			System.out.println("?");
		}
		
	}
}
