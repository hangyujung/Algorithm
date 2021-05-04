import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class Solution {
    public static int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray())
            if(!stack.isEmpty() && stack.peek() == c) stack.pop();
            else stack.push(c);

        return stack.isEmpty() ? 1 : 0;
    }


    @Test
    public void 정답() {
        String prob= "baabaa";
        int expected = 1;
        Assert.assertEquals(expected, solution(prob));
    }
}
