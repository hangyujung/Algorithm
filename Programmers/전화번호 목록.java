import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        int z;
        Arrays.sort(phone_book);
        for(int i=0;i<phone_book.length-1;i++){
            for(int j=i+1;j<phone_book.length;j++){
                for(z=0;z<phone_book[i].length();z++){
                    System.out.println(phone_book[i].charAt(z));
                    if(phone_book[i].charAt(z)!=phone_book[j].charAt(z)) break;

                }
                if(z==phone_book[i].length()){
                    return false;
                }
            }
        }
        return answer;

    }
}
//해시 lv.2
