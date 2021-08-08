import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


public class Solution {
    public String solution(String s) {
        char[] ca = s.toCharArray();
        Arrays.sort(ca);

        return new StringBuilder(new String(ca)).reverse().toString();
    }

    @Test
    public void 정답() {
        String prob= "Zbcdefg";
        String expected = "gfedcbZ";
        Assert.assertEquals(expected, solution(prob));

    }
}
