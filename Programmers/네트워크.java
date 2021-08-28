class Solution {

    static int[] no1s;
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        no1s=new int[n];
        visited = new boolean[n];
        for(int i=0;i<n;i++){
            no1s[i]=i;
        }
        for(int r=0;r<computers.length;r++){
            for(int c=0;c<computers[r].length;c++){
                if(r!=c&&computers[r][c]==1){
                    union(r,c);
                }
            }
        }
        int temp=-1;
        // for(int data:no1s){
        //     if(temp!=data) {
        //         answer++;
        //         temp=data;
        //     }
        // }
        for(int i=0;i<n;i++){
            if(!visited[find(no1s[i])]){
                answer++;
                visited[find(no1s[i])] = true;
            }
        }
        return answer;
    }
    static void union(int r,int c){
        int r_p=find(r);
        int c_p=find(c);
        no1s[c_p]=r_p;
        
    }
    static int find(int n){
        if(n==no1s[n]) return n;
        return no1s[n]=find(no1s[n]);
    }
}
