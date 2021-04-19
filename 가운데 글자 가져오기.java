

class Solution {
    public String solution(String s) {
         int size=s.length();
        String answer="";
        System.out.println(size/2);
        if((size%2)==1) {
            answer=s.substring(size/2,size/2+1);
        }
        else {
            answer=s.substring(size/2-1,size/2+1);
        }
        return answer;
    }
}
