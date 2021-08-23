


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//2초
public class BOJ_S5_크로아티아알파벳 {
	static String s;
	
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int croatia=0;
		s = br.readLine();
		int answer=check(s);
		
		System.out.println(answer);
//		for(int i=0;i<s.length()-2;i++) {
//			if(check(s.substring(i,i+3))){
//				croatia++;
//				
//			}
//		}
//		int answer= s.length()-croatia;
//		System.out.println(answer);
		
	}

	private static int check(String s) {
		String croa_alpha[]= {"c=","c-","dz=","d-","lj","nj","s=","z="};
		for(int i=0;i<croa_alpha.length;i++) {
			if(s.contains(croa_alpha[i])) {
				s=s.replace(croa_alpha[i], "*");
			}
		}
		return s.length();
	}
}
