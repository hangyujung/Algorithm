import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;


public class Ex0422 {
    public int solution(String[][] clothes) {
        int answer=1;
        HashMap<String, Integer> hm = new HashMap<>();
        int rows = clothes.length;
        for(int i=0;i<rows;i++){
            if(hm.get(clothes[i][1]) == null){
                hm.put(clothes[i][1],1);
            }
            else{
                hm.put(clothes[i][1],hm.get(clothes[i][1])+1);
            }
        }

        for(String keys:hm.keySet()){

            answer *= hm.get(keys)+1;
        }
        answer--;
        return answer;
    }

    @Test
    public void 정답() {
        int expected = 5;
        String[][] prob= {{"yellowhat", "headgear"},{"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        Assert.assertEquals(expected, solution(prob));

    }
}
