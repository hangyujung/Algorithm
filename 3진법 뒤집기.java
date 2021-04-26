import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;

import java.util.ArrayList;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String str = "";
        while(n!=0){
            str += n%3;
            n= n/3;
        }
        for(int i=0;i<str.length();i++){
            answer += Math.pow(3,i)*Character.getNumericValue(str.charAt(str.length()-1-i));
        }
        return answer;

    }

    @Test
    public void 정답() {
        int expected = 7;
        int prob= 45;
        Assert.assertEquals(expected, solution(prob));

    }
}
