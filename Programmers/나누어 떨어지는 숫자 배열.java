import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;

import java.util.ArrayList;


public class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]%divisor==0) list.add(arr[i]);

        }
        int[] answer;
        if(list.size()==0) {
            answer = new int[]{-1};
        }
        else {
            answer =new int[list.size()];
        }

        int k=0;
        for(int data:list){
            answer[k]=data;
            System.out.println(data);
            k++;
        }
        Arrays.sort(answer);
        return answer;
    }

    @Test
    public void 정답() {
        int[] expected = {5,10};
        int[] prob= {5,9,7,10};
        Assert.assertArrayEquals(expected, solution(prob,5));

    }
}
