import java.util.ArrayList;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;

        int[] dayOfend = new int[100];
        int day = -1;
        for(int i=0; i<progresses.length; i++) {
            while(progresses[i] + (day*speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : dayOfend) {
            System.out.println(i);
            if(i!=0) {list.add(i);}
        }

        answer = new int[list.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}

//스택 큐 lv2
