


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//시간제한: 초
public class SWEA_D4_서로소집합 {
	private static int[] no1;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			no1 = new int[N+1];
			for(int n=1;n<=N;n++) {
				no1[n]= n;
			}
			sb.append("#"+(t+1)+" ");
			for(int m =0;m<M;m++) {
				st =new StringTokenizer(br.readLine());
				String op = st.nextToken();
				if(op.equals("0")) {
					int no1A = findNo1(Integer.parseInt(st.nextToken()));
					int no1B = findNo1(Integer.parseInt(st.nextToken()));
					if(no1A!=no1B)no1[no1B] = no1A;
				}
				else{
					int no1A = findNo1(Integer.parseInt(st.nextToken()));
					int no1B = findNo1(Integer.parseInt(st.nextToken()));
					if(no1A==no1B) {
						sb.append("1");
					}else {
						sb.append("0");
					}
				}
				
			}
			
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static int findNo1(int n) {
		if(n==no1[n]) return n;		
		return no1[n]=findNo1(no1[n]);
	}
}
