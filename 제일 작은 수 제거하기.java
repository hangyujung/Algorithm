import org.junit.Assert;
import org.junit.Test;



public class Solution {
    public int[] solution(int[] arr) {
        if(arr.length<=1){
            int[] answer ={-1};
            return answer;
        }
        int min=arr[0];

        for(int i=1;i<arr.length;i++){
            min=Math.min(min,arr[i]);
        }
        int[] answer = new int[arr.length-1];
        int index=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]==min){
                continue;
            }
            answer[index++]= arr[i];
        }
        return answer;
    }

    @Test
    public void 정답() {
        int[] prob= {4,2,3,1};
        //int prob2= {5,4,4};
        int[] expected = {4,2,3};
        Assert.assertArrayEquals(expected, solution(prob));
    }
}
