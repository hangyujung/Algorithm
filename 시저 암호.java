import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class Solution {
    public String solution(String s, int n) {
        String answer = "";
        for(int i=0;i<s.length();i++) {
            char ch=s.charAt(i);

            if(ch>='a' && ch <='z'){
                if(ch+n>'z') answer += (char)(ch+n-26);
                else answer += (char)(ch+n);
            }
            else if (ch>='A' && ch<='Z') {
                if (ch + n > 'Z') answer += (char) (ch + n - 26);
                else answer += (char) (ch + n);
            }
                else answer += (char)ch;

        }

        return answer;
    }


    @Test
    public void 정답() {
        Solution cc = new Solution();
        String prob= "AB";
        String expected = "BC";
        Assert.assertEquals(expected, solution(prob,1));
    }
}
