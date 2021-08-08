import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.ArrayList;


public class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(!list.contains(nums[i])) {
                list.add(nums[i]);
            }
        }
        System.out.println(list.toString());
        if(list.size()>=nums.length/2) answer = nums.length/2;
        else answer = list.size();

        return answer;
    }


    @Test
    public void 정답() {
        int[] prob= {3,1,2,3};
        int expected = 2;
        Assert.assertEquals(expected, solution(prob));

    }
}
