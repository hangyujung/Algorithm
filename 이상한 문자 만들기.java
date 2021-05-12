class Solution {
    public String solution(String s) {
        String answer = "";
        int seq=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                seq=0;
                answer+=' ';
            }
            else if(seq%2==0){
                answer+=Character.toString(s.charAt(i)).toUpperCase();
                seq++;
            }
            else {
                answer+=Character.toString(s.charAt(i)).toLowerCase();;
                seq++;
            }
        
        }
        return answer;
    }
}
