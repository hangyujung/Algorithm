



import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//시간제한: 2초
public class BOJ_G5_암호만들기 {
	private static char[] carr, answer;
	private static int L;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		carr = new char[C];
		answer= new char[L];
		st=new StringTokenizer(br.readLine());
		for(int c=0;c<C;c++) {
			carr[c] = st.nextToken().charAt(0); 
		}
		
		Arrays.sort(carr);
		combination(0,0);
		
		
	}

	private static void combination(int count, int start) {
		if(count==L) {
			if(check(answer)) {
//				Arrays.sort(answer);
				System.out.println(answer);
			}
			return;
		}
		
		for(int i=start;i<carr.length;i++) {
			answer[count] = carr[i];
			combination(count+1, i+1);
		}
	}

	private static boolean check(char[] answer) {
		String moum =  "aeiou";
		int moumCount=0;
		for(int i=0;i<answer.length;i++) {
			if(moum.indexOf(answer[i])>=0) {
				moumCount++;
			}
		}
		if(moumCount>=1 && moumCount<answer.length-1) return true;
		return false;
	}
}
