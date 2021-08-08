import org.junit.Assert;
import org.junit.Test;


public class Ex0422 {
    public int solution(int[] nums) {

        int sum=0;
        int count=0;


        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int z=j+1;z<nums.length;z++){
                    sum=nums[i]+nums[j]+nums[z];
                    if(isPrime(sum)) count++;

                }
            }
        }

        return count;
    }

    private boolean isPrime(int num) {

        boolean result = true;
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) {
                result = false;
            }
        }

        return result;
    }

    @Test
    public void 정답() {
        int expected = 1;
        int[] prob= {1,2,3,4};
        Assert.assertEquals(expected, solution(prob));

    }
}
