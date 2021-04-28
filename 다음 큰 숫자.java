class Solution {
    public int solution(int n) {
        int answer = 0;
        int i=n;
        int ones=0;
        while(n>0){
            if(n%2==1) ones++;
            n=n/2;
        }
        while(i<1000000){
            i++;
            if(check_ones(ones,i)) {
                answer=i;
                break;
            }
        }
        return answer;
        }
    boolean check_ones(int target,int i){
        int one_count=0;
        while(i>0){
            if(i%2==1) one_count++;
            i=i/2;
        }
        if(one_count==target) return true;
        else return false;
    }
}

//Integer.parseInt
//Integer.bitCount(num)  : num 숫자를 binary로 변환후, 1의 수를 반환



