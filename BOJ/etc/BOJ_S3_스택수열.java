
import java.io.*;
import java.util.*;

public class BOJ_S3_스택수열  {
	public static void main(String[] args) throws IOException {
		//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int start=1;
		for(int n=1;n<=N;n++) {
			int num = Integer.parseInt(br.readLine());
			
			if(!stack.isEmpty()&&stack.peek()==num) {
				stack.pop();
				sb.append("-"+"\n");
				//System.out.println("-");
			}
			else if(!stack.isEmpty()&&stack.peek()>num) {
				System.out.println("NO");
				System.exit(0);
			}
			else{
				for(int i=start;i<=num;i++) {
					stack.push(i);
					start++;
					//System.out.println("+");
					sb.append("+"+"\n");
				}
				stack.pop();
				//System.out.println("-");
				sb.append("-"+"\n");
			}
		}
		System.out.println(sb);
	}
}