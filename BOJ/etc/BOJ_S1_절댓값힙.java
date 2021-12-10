


import java.io.*;
import java.util.*;

public class BOJ_S1_절댓값힙 {
	public static void main(String[] args) throws IOException {
		//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if(Math.abs(o1)==Math.abs(o2)) {
					if(o1>o2) return 1;
					else return -1;
				}
				return Math.abs(o1)-Math.abs(o2);
			}
		});
		
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
