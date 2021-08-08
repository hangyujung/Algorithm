import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;


class Solution {
     public int solution(int[] d, int budget) {
        int answer = 0;
        int len=d.length;
        Arrays.sort(d);
        for(int i=0;i<len;i++){
            budget-=d[i];
            if(budget>=0) answer++;
            else break;
        }
        return answer;
    }

    @Test
    public void 정답() {
        int expected = 3;
        int[] prob= {1,3,2,5,4};
        Assert.assertEquals(expected, solution(prob,9));

    }
}
