

import java.io.*;
import java.util.*;

public class BOJ_B5_AminusB {
	public static void main(String[] args) throws IOException {
		//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		System.out.println(Integer.parseInt(st.nextToken())-Integer.parseInt(st.nextToken()));
	}
}
