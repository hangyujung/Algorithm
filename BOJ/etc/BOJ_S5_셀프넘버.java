


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//시간제한: 초
public class BOJ_S5_셀프넘버 {
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		boolean answer[] = new boolean[10001];
		int i=1;
		
		while(i<=10000) {
			int result=0;
			
			int c=calc(i);
			if(c<=10000) answer[c]=true;
			
			i++;
		}
		for(int j=1;j<answer.length;j++) {
			if(!answer[j]) System.out.println(j);
		}
		
	}

	private static int calc(int i) {
		int sum=i;
		while(i>0) {
			sum+=i%10;
			i/=10;
		}
		return sum;
	}
}
