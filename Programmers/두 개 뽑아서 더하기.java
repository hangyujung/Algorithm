import java.util.ArrayList;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer;
        ArrayList<Integer> arrList = new ArrayList<>();
        
        for(int i=0; i<numbers.length-1; i++){
            for(int j=i+1; j<numbers.length; j++){
     
                if(!arrList.contains(numbers[i]+numbers[j])){
                    arrList.add(numbers[i]+numbers[j]);
                }
            }
        }
        
 
        arrList.sort(null);
        
        int cnt = 0;
        answer = new int[arrList.size()];
        for(int arr : arrList){
            answer[cnt++] = arr;
        }
        return answer;
    }
}
