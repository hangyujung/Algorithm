
import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_일곱난쟁이 {

    public static void main(String[] args)  {

        Scanner scan=new Scanner(System.in);
        int[] arr = new int[9];
        int out, sum=0;
        int x=0;
        int y=0;
        for(int i=0;i<9;i++){
            arr[i]=scan.nextInt();
            sum+=arr[i];
        }
        Arrays.sort(arr);
        label: for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j< arr.length;j++){
                out=arr[i]+arr[j];
                if(sum-out==100){
                    x=i;
                    y=j;
                    break label;
                }
            }
        }

        for(int data: arr){
            if(data!=arr[x]&&data!=arr[y]){
                System.out.println(data);
            }
        }

    }
}
