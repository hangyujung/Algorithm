

import java.io.*;
import java.util.*;


//시간제한
class Saram implements Comparable<Saram>{
	int a;
	int b;
	Saram(int a,int b){
		this.a=a;
		this.b=b;
	}
	@Override
	public int compareTo(Saram o) {
		return this.a-o.a;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return a+" : "+b;
	}
	
}
public class BOJ_S1_신입사원 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			int N = Integer.parseInt(br.readLine());
			ArrayList<Saram> list = new ArrayList<>();
			for(int n=0;n<N;n++) {
				st = new StringTokenizer(br.readLine());
				int a= Integer.parseInt(st.nextToken());
				int b= Integer.parseInt(st.nextToken());
				list.add(new Saram(a,b));
				
			}
			Collections.sort(list);
			int min = list.get(0).b;
			int answer=1;
			for(int i=1;i<N;i++) {
				if(list.get(i).b<min) {
					answer++;
					min = list.get(i).b;
				}
			}
			System.out.println(answer);
		}
	}
}
