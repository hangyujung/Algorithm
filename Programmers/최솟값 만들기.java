import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class Solution {
        public int solution(int []A, int []B)
        {
            int answer = 0;
            Arrays.sort(A);
            Arrays.sort(B);
            for(int i=0;i<A.length;i++){
                answer += A[i]*B[A.length-1-i];
            }

            System.out.println("Hello Java");

            return answer;
        }



    @Test
    public void 정답() {
        int[] prob= {1,4,2};
        int[] prob2= {5,4,4};
        int expected = 29;
        Assert.assertEquals(expected, solution(prob,prob2));
    }
}
