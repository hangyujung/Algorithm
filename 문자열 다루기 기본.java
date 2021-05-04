import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


public class Solution {
    public boolean solution(String s) {
        boolean answer = false;
        if(s.length()==4 || s.length()==6 ){
          for(int i=0;i<s.length();i++) {
              if (0 <= s.charAt(i) - '0' && s.charAt(i) - '0' <= 9)
                  answer = true;
              else {
                  answer =false;
                  break;
              }
          }
        }
        return answer;
    }

    @Test
    public void 정답() {
        String prob= "1e22";
        boolean expected = false;
        Assert.assertEquals(expected, solution(prob));
    }
}
