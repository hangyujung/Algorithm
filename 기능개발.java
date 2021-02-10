class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = new int[100];
        
        int[] days =new int[progresses.length];
        for(int i=0;i<progresses.length;i++){
            int day=1;
            while (100>progresses[i]+speeds[i]*day){
                day++;
            }
            days[i]=day;
        }
        int min=days[0];
        int count=1;
        int sameday=1;
        for(int i=1;i<days.length;i++){
            if(min<days[i]){
                count++;
            }
            else{
                sameday++;
            }
            
            answer[i-1]=sameday;
        }
        for(int d : answer){
            System.out.println(d);
        }
    
        return answer;
    }
}
