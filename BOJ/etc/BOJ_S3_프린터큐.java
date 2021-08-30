

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int priority;
	boolean flag=false;
	public Node(int p,boolean f) {
		this.priority=p;
		this.flag=f;
	}
	@Override
	public int compareTo(Node o) {
		return -(this.priority-o.priority);
	}
}
public class BOJ_S3_프린터큐 {
	private static int N;
	private static ArrayList<Node> list;

	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st;
		 StringBuilder sb = new StringBuilder();
		 
		 int T = Integer.parseInt(br.readLine());
		 for(int t=0;t<T;t++) {
			 st= new StringTokenizer(br.readLine());
			 N = Integer.parseInt(st.nextToken());
			 int idx = Integer.parseInt(st.nextToken());
			 list = new ArrayList<>(); 
			 int count=0;
			 st= new StringTokenizer(br.readLine());
			 for(int n=0;n<N;n++) {
				 boolean flag=false;
				 if(n==idx) flag=true;
				 list.add(new Node(Integer.parseInt(st.nextToken()),flag));
		 	}
			 
			while(!list.isEmpty()) { 
				if(check(list.get(0).priority)) {
					count++;
					if(list.get(0).flag) {
						break;
					}
					list.remove(0);
					
				}
				else {
				 list.add(list.size()-1, list.remove(0));
				}
			}
			sb.append(count+"\n");
		 }
		 System.out.println(sb);
	 }

	private static boolean check(int priority) {
		for(int i=1;i<list.size();i++) {
			if(priority<list.get(i).priority) return false;
		}
		return true;
	}
}

