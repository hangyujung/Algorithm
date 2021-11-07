

import java.io.*;
import java.util.*;

//시간제한
public class BOJ_S4_균형잡힌세상 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Stack<Character> stack;
		label: while(br.ready()) {
			stack = new Stack<>();
			String s = br.readLine();
			if(s.equals(".")) System.exit(0);
			sb.append(s);
			if(s.charAt(s.length()-1)!='.') {
				continue;
			}
//			System.out.println(sb);
			
			for(int i=0;i<sb.length();i++) {
				if(sb.charAt(i)=='(' || sb.charAt(i)=='[') {
					stack.add(sb.charAt(i));
				}
				else if(sb.charAt(i)==')'|| sb.charAt(i)==']'){
					if(stack.empty()) {
						System.out.println("no");
						sb.setLength(0);
						continue label;
					}
					char c = stack.pop();
					
					if(c=='(') {
						if(sb.charAt(i)!=')') {
							System.out.println("no");
							sb.setLength(0);
							continue label;
						}
					}
					else {
						if(sb.charAt(i)!=']') {
							System.out.println("no");
							sb.setLength(0);
							continue label;
						}
					}
				}
			}
			
			if(stack.isEmpty()) System.out.println("yes");
			else System.out.println("no");
			sb.setLength(0);
		}

	}
}



