


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//시간제한: 초
public class BOJ_S5_참외밭 {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int K = Integer.parseInt(br.readLine());
		int maxWidth=0,maxWidth_idx=0,maxHeight=0,maxHeight_idx=0,smallWidth=0,smallHeight=0;
		int[][] map = new int[6][2];
		for(int i=0;i<6;i++) {
			st=new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			if(dir==1||dir==2) {
				if(len>maxWidth) {
					maxWidth_idx = i;
					maxWidth = len;
				}
			}
			else{
				if(len>maxHeight) {
					maxHeight_idx = i;
					maxHeight = len;
				}
			}
			map[i][0] = dir;
			map[i][1] = len;
		}
		int maxHeight_idx_back = (maxHeight_idx+1)%6;
		int maxHeight_idx_front = (maxHeight_idx-1)<0?5:maxHeight_idx-1;
		int maxWidth_idx_back = (maxWidth_idx+1)%6;
		int maxWidth_idx_front = (maxWidth_idx-1)<0?5:maxWidth_idx-1;
		
		smallWidth = Math.abs(map[maxHeight_idx_back][1]-map[maxHeight_idx_front][1]);
		smallHeight = Math.abs(map[maxWidth_idx_back][1]-map[maxWidth_idx_front][1]);
		 
		System.out.println((maxHeight*maxWidth-smallHeight*smallWidth)*K);
		
		
		
	}
}
