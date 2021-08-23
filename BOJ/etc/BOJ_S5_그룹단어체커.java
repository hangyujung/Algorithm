

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//2초
public class BOJ_S5_그룹단어체커 {
	public static void main(String[] args) throws IOException {
	boolean[] checked;
	BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	int T = Integer.parseInt(br.readLine());
	int count = 0;
	for(int t=0;t<T;t++) {
		boolean flag=true;
		checked = new boolean[26];
		char[] carr = br.readLine().toCharArray();
		for(int i=0;i<carr.length;i++) {
			char c = carr[i];
			if(!checked[c-'a']) {
				checked[c-'a']=true;
				int j=i+1;
				while(j<carr.length&&c==carr[j]) {
					j++;
					i++;
				}
				
			}else {
				flag=false;
				break;
			}
			
		}
		if(flag) count++;
		
	}
	System.out.println(count);
		
	}
}
