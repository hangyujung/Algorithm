


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//시간제한: 초
public class BOJ_G5_AC {
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st=null;
		
		int T = Integer.parseInt(br.readLine());
		label: for(int t=1;t<=T;t++) {
			String cmd = br.readLine();
			int N = Integer.parseInt(br.readLine());
			ArrayList<Integer> nums = new ArrayList<>();
			String s = br.readLine();
			int i=0;
			StringBuilder num= new StringBuilder(); 
			while(s.charAt(i++)!=']') { //10만
				
				if(Character.isDigit(s.charAt(i))){
					num.append(s.charAt(i));
				}
				
				else if(s.charAt(i)==',') {
					nums.add(Integer.parseInt(num.toString()));
					num.setLength(0);
				}
				
			}
			if(num.length()!=0) {
				nums.add(Integer.parseInt(num.toString()));
			}
			
			boolean flag=true;
			for(int x=0;x<cmd.length();x++) { //10만
				if(cmd.charAt(x)=='R') {
//					Collections.reverse(nums); //10만
					flag=!flag;
				}
				else if(cmd.charAt(x)=='D') {
					if(nums.size()==0) {
						sb.append("error\n");
						continue label;
					}
					if(flag) nums.remove(0);
					else nums.remove(nums.size()-1);
				}
			}
			sb.append("[");
			if(flag) {
				for(int x=0;x<nums.size();x++) {
					sb.append(nums.get(x));
					sb.append(",");
				}
			}else {
				for(int x=nums.size()-1;x>=0;x--) {
					sb.append(nums.get(x));
					sb.append(",");
				}
			}
			if(nums.size()!=0) sb.deleteCharAt(sb.length()-1);
			sb.append("]\n");
		}
		System.out.println(sb);
	}
}
