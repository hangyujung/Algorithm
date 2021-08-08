import org.junit.Assert;
import org.junit.Test;


public class Solution {
    public int[] solution(long n) {
        String a = n+"";
        int[] answer = new int[a.length()];

        for(int i=0;i<a.length();i++){
            answer[i]= (int) (n%10);
            n=n/10;

        }
        return answer;
    }

    @Test
    public void 정답() {
        int prob= 12345;
        //int prob2= {5,4,4};
        int[] expected = {5,4,3,2,1};
        Assert.assertArrayEquals(expected, solution(prob));
    }
}
