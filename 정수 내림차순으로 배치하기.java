import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;


public class Solution {
    public long solution(long n) {
        String arr[]=String.valueOf(n).split("");

        Arrays.sort(arr);
        String str = "";

        for(int i=arr.length-1; i>=0; i--){
            str+= arr[i];
        }

        return Long.parseLong(str);
    }



    @Test
    public void 정답() {
        int prob= 118372;
        //int prob2= {5,4,4};
        int expected = 873211;
        Assert.assertEquals(expected, solution(prob));
    }
}
