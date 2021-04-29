import java.util.*;

class Solution {
    int solution(int[][] land) {

    	for ( int i = 1; i < land.length; i ++ ) {
    		
    		// 2번째의 0~3번째 index의 max값 부터 누적해 간다.
    		land[i][0] += Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][3]));
    		land[i][1] += Math.max(land[i-1][0], Math.max(land[i-1][2], land[i-1][3]));
    		land[i][2] += Math.max(land[i-1][1], Math.max(land[i-1][0], land[i-1][3]));
    		land[i][3] += Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][0]));

    		//1회전 할 때 마다 선택 될 수 있는 max값의 배열을 새로 만들게 된다.
    	}
    	
    	int[] answer = land[land.length-1];
    	Arrays.sort(answer);
    	
    	return answer[answer.length-1] ;
    
    }
}

//dp 문제 lv2
