

import java.io.*;
import java.util.*;

//시간제한
public class BOJ_G5_FlyMeToTheAlphaCentauri {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			st= new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			int distance =  end-start;
			int max = (int) Math.sqrt(distance);
			int count=0;
			if(max*max== distance) count = max*2-1;
			else if(max*max+max>=distance) count=max*2;
			else count = max*2+1;
			
			System.out.println(count);
			
		}
		
	}
}
