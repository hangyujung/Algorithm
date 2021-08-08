import jdk.dynalink.beans.StaticClass;
import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Stack;


public class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack stack = new Stack();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push('(');
            }
            else{
                if(stack.empty()) return false;
                stack.pop();
            }
        }
        if(!stack.empty()) return false;

        return answer;
    }


    @Test
    public void 정답() {
        String prob= "()()";
        boolean expected = true;
        Assert.assertEquals(expected, solution(prob));

    }
}
