


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//시간제한: 초
public class 창용마을무리의개수 {
	private static int[] no1s;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			st=new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int count=0;
			no1s = new int[N+1];
			for(int i=1;i<=N;i++) {
				no1s[i]=i;
			}
			for(int m=0;m<M;m++) {
				st= new StringTokenizer(br.readLine());
				union(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			int temp=0;
			boolean daejang[] = new boolean[N+1];
			for(int i=1;i<=N;i++) {
				
				int no1=find(no1s[i]);
				if(!daejang[no1]) {
					daejang[no1]=true;
					count++;
				}
			}
			sb.append("#"+(t+1)+" "+count+"\n");
		}
		System.out.println(sb);
	}

	private static void union(int a, int b) {
		int no1_a=find(a);
		int no1_b=find(b);
		if(no1_a!=no1_b) no1s[no1_b]=no1_a;
	}

	private static int find(int a) {
		if(no1s[a]==a) return a;
		return no1s[a]=find(no1s[a]);
	}
}
