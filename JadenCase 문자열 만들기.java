import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;


public class Solution {
    public String solution(String s) {
        String answer = "";
        boolean jaden=false;

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch==' '){
                jaden=true;
                answer+=" ";
                continue;
            }
            if(jaden==true || i==0){
                if(ch>='a' && ch<='z'){
                    answer+=Character.toUpperCase(ch);
                }
                else{
                    answer+=ch;
                }
                jaden=false;
                continue;
            }
            else {
                answer+=Character.toLowerCase(ch);
                continue;
            }


        }
        return answer;
    }




    @Test
    public void 정답() {
        String prob= "for the last week";
        //int prob2= {5,4,4};
        String expected = "For The Last Week";
        Assert.assertEquals(expected, solution(prob));
    }
}
