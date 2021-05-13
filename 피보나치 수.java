class Solution {

    public int solution(int n) {
        int answer = 0;
        int[] pib=new int[n+1];
        pib[0]=0;
        pib[1]=1;

        for(int i=2; i<=n; i++){
            pib[i]=(pib[i-1]+pib[i-2])%1234567;
        }
        answer=(pib[n]);
        return answer;
    }
}
