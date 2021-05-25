import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;


public class Solution {
    public long solution(long n) {
        long answer = -1;
        for(double i=0;i<=Math.sqrt(n);i++){
            if(n==Math.pow(i,2)){
                answer= (long) Math.pow(i+1,2);
                break;
            }
        }
        return answer;
    }

    @Test
    public void 정답() {
        long prob= 121;
        //int prob2= {5,4,4};
        long expected = 144;
        Assert.assertEquals(expected, solution(prob));
    }
}


/*

프로그래머스 다른사람의 풀이 

class Solution {
  public long solution(long n) {
      if (Math.pow((int)Math.sqrt(n), 2) == n) {
            return (long) Math.pow(Math.sqrt(n) + 1, 2);
        }

        return -1;
  }
}


*/
