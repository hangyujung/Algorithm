import java.util.*;
import java.util.ArrayList;

public class Solution {
    public int[] solution(int []arr) {

        ArrayList<Integer> list = new ArrayList<>();
        int i=0;
        list.add(arr[0]);
        for(int data: arr){
            if(list.get(i) != data){
                list.add(data);
                i++;
            }
        }
        i=0;
        int[] answer = new int[list.size()];
        Iterator<Integer> it = list.iterator();
        while(it.hasNext()){
            answer[i]=  it.next();
            i++;
            
        }





        return answer;
    }
}
