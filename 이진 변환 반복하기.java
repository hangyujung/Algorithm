import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


public class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int count=0;
        int zeros=0;
        while(!s.equals("1")){
            int ones=0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='0'){
                    zeros++;
                }
                else ones++;
            }
            s=Integer.toBinaryString(ones);
            count++;
        }
        answer[0] = count;
        answer[1] = zeros;
        return answer;
    }
    @Test
    public void 정답() {
        String prob= "01110";
        int[] expected = {3,3};
        Assert.assertArrayEquals(expected, solution(prob));
    }
}
