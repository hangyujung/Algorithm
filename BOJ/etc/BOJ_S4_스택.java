

	import java.io.*;
	import java.util.*;

	public class BOJ_S4_스택 {
		public static void main(String[] args) throws IOException {
			//		System.setIn(new FileInputStream("input.txt"));
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb = new StringBuilder();
			StringTokenizer st = null;
			
			int N = Integer.parseInt(br.readLine());
			Stack<Integer> stack = new Stack<>();
			for(int n=0;n<N;n++) {
				st =new StringTokenizer(br.readLine());
				String s = st.nextToken();
				if(s.equals("push")) {
					stack.push(Integer.parseInt(st.nextToken()));
				}
				else if(s.equals("pop")){
					if(stack.size()>0) System.out.println(stack.pop());
					else System.out.println(-1);
				}
				else if(s.equals("size")) {
					System.out.println(stack.size());
				}
				else if(s.equals("empty")) {
					if(stack.isEmpty()) {
						System.out.println(1);
					}else {
						System.out.println(0);
					}
				}
				else if(s.equals("top")) {
					if(stack.size()>0) System.out.println(stack.peek());
					else System.out.println(-1);
				}
				
			}
			
			
	}
}
