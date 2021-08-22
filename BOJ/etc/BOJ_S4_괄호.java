package day0820;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_S4_괄호 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			String answer="";
			char[] ch_arr = br.readLine().toCharArray();
			Stack<Character> stack = new Stack<>();
			for(int i=0;i<ch_arr.length;i++) {
				if(ch_arr[i]=='(') stack.push(ch_arr[i]);
				else {
					if(!stack.empty()) {
						stack.pop();
					}
					else {
						answer="NO";
						break;
					}
				}
			}
			if(answer!="NO"&&stack.isEmpty()) answer="YES";
			else answer="NO";
			System.out.println(answer);
		}
	}
}
