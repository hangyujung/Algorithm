

import java.io.*;
import java.util.*;

public class BOJ_S4_제로 {
	public static void main(String[] args) throws IOException {
		//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int sum=0;
		Stack<Integer> stack = new Stack<>();
		for(int n=1;n<=N;n++) {
			int num = Integer.parseInt(br.readLine());
			if(num==0) {
				stack.pop();
			}
			else {
				stack.add(num);
			}
		}
		while(!stack.isEmpty()) {
			sum+=stack.pop();
		}
		System.out.println(sum);
	}
}