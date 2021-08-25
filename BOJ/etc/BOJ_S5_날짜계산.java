


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//시간제한: 2초
public class BOJ_S5_날짜계산 {
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		st= new StringTokenizer(br.readLine());
		
		int e = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int i=1;
		int E=1,S=1,M=1;
		while(true) {
			if(e==E && s==S && m ==M) {
				System.out.println(i);
				break;
			}
			i++;
		
			E++;S++;M++;
			if(E==16)E=1;
			if(S==29)S=1;
			if(M==20)M=1;
		}
		
	}
}
