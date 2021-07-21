import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {

        Scanner scan=new Scanner(System.in);
        int T = scan.nextInt();
        for(int t=0;t<T;t++){
            String s= scan.next();
            String[] nums = s.split(",");

            int num=Integer.parseInt(nums[0])+Integer.parseInt(nums[1]);
            System.out.println(num);
        }


    }
}
