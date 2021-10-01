package week9_4;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

//시간제한: 초
class Topni{
	LinkedList<Integer> nsarr= new LinkedList<>();
	
	
	public boolean spinL(int Lvalue) {
		if(Lvalue!=nsarr.get(2)) {
			return true;
		}
		return false;
	}
	public boolean spinR(int Rvalue) {

		if(Rvalue!=nsarr.get(6)) {
			return true;
		}
		
		return false;
	}

	//LinkedList로 교체
	void rightmove() {
//		int temp=nsarr[7];
//	   for(int i =nsarr.length-1;i>=1;i--){
//		   nsarr[i] = nsarr[i-1];
//	    }
//	   nsarr[0]=temp;
		nsarr.add(0,nsarr.remove(7));
	}
	void leftmove() {
//		int temp=nsarr[0];
//		for(int i =1; i<=nsarr.length-1;i++){
//			nsarr[i-1]=nsarr[i];
//		}
//		nsarr[7]=temp;
		nsarr.add(nsarr.remove(0));
	}


	public void spin(int dir) {
		if(dir==1) {
			rightmove();
		}
		else if(dir==-1) {
			leftmove();
		}
	}
}
public class SWEA_모의SW_특이한자석 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			int answer=0;
			int K = Integer.parseInt(br.readLine());
			Topni[] tparr = new Topni[5];
			for(int n=1;n<=4;n++) {
				tparr[n]=new Topni();
				st= new StringTokenizer(br.readLine());
				for(int i=1;i<=8;i++) {
					tparr[n].nsarr.add(Integer.parseInt(st.nextToken()));
				}
				
			}
			for(int k=0;k<K;k++) {
				st =new StringTokenizer(br.readLine());
				int N = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				int NL=N;
				int DL=dir;
				int NR=N;
				int DR=dir;
				int[] check = new int[5];
				
				while(NL>1) {

					if(tparr[NL].nsarr.get(6)==tparr[NL-1].nsarr.get(2)) {
						break;
					}
					NL--;
					DL*=-1;
					check[NL]=DL;
				}
				
				while(NR<4) {
	
					if(tparr[NR].nsarr.get(2)==tparr[NR+1].nsarr.get(6)) {  //같지않으면 트루리턴 하니깐 break로 안빠짐
						break;
					}
					NR++;
					DR*=-1;
					check[NR]=DR;
				}
				check[N]=dir;
				for(int i=1;i<=4;i++) {
					if(check[i] != 0 ) {
						tparr[i].spin(check[i]);
					}
				}
			}
			int a=0;
			for(Topni d:tparr) {
				if(d==null) continue;
				int score=(int) Math.pow(2, a);
				a++;
				if(d.nsarr.get(0)==1)answer+=score;
			}
			sb.append("#"+t+" "+answer+"\n");
		}
		System.out.println(sb);
	}
	//동시에 --> 회전 대상 파악을 하고 한번에 처리
}
