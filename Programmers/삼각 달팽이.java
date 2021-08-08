class Solution {
    public int[] solution(int n) {
        int[][] li = new int[n][n];
        int x=0,y=0;
        int step = n;
        int value=1;
        while(step >0){
            /*아래로 이동 */
            for(int i=step;i>0;i--){
                li[x++][y] = value++;
            }
            x--; // 행 복귀 
            y++; // 로테이션
            step--; // 스텝 업데이트

            /* 오른쪽 이동 */
            for(int i=step;i>0;i--){
                li[x][y++] = value++;
            }
            y--; // 열 복귀
            x--; // 로테이션
            y--; // 로테이션
            step--;

            /* 북서쪽 이동 */
            for(int i=step;i>0;i--){
                li[x--][y--] = value++;
            }
            x++; // 행 복귀
            y++; // 열 복귀
            x++; // 로테이션
            step--;
        }

        int[] answer = new int[n*(n+1)/2];
        int size=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(li[i][j]==0) break;
                answer[size++] = li[i][j];
            }
        }
        return answer;
    }
}
