

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Student implements Comparable<Student> {
	String name;
	int kor,eng,math;
	public Student(String name, int kor, int eng, int math) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	@Override
	public int compareTo(Student o) {
		if(this.kor==o.kor) {
			if(this.eng==o.eng) {
				if(this.math==o.math) {
					return this.name.compareTo(o.name);
				}
				else return -(this.math-o.math);
			}
			else return this.eng-o.eng;
		}
		else return -(this.kor-o.kor);
	}
	
}

public class BOJ_S4_국영수 {
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Student[] st_arr = new Student[N];
		for(int n=0;n<N;n++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int kor = Integer.parseInt(st.nextToken());
			int eng = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			st_arr[n]= new Student(name,kor,eng,math);
		}
		Arrays.sort(st_arr);
		for(Student person : st_arr) {
			System.out.println(person.name);
		}
	}
}
