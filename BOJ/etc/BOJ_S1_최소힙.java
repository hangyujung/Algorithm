

import java.io.*;
import java.util.*;

public class BOJ_S1_최소힙 {
	public static void main(String[] args) throws IOException {
		//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());
		for(int n=1;n<=N;n++) {
			int num = Integer.parseInt(br.readLine());
			if( num == 0 ) {
				if(pq.isEmpty()) System.out.println(0);
				else System.out.println(pq.poll());
			}
			else {
				pq.add(num);
			}
		}
		
	}
}
