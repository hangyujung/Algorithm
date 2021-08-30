import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;


class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        String start="";
        ArrayList<String> list = new ArrayList<>();
        int[] visited = new int[words.length];
    
        
        
        Queue<String> que = new LinkedList<>();
      
        
        int step=0;
        que.add(begin);
        while(!que.isEmpty()){
            String temp = que.poll();
            for(int i=0;i<words.length;i++){
                if(temp.equals(words[i])){
                    step=visited[i];
                    break;
                }    
            }
            
            if(temp.equals(target)){
                for(int i=0;i<words.length;i++){
                    if(temp.equals(words[i])){
                        return visited[i];

                    }    
                }
            }
            
            for(int i=0;i<words.length;i++){
                int sameCount=0;
                if(visited[i]==0){
                    for(int j=0;j<temp.length();j++){
                        if(words[i].charAt(j)==temp.charAt(j)){
                            sameCount++;
                            if(sameCount==temp.length()-1){
                                que.add(words[i]);
                                visited[i]=step+1;
                            }
                        }
                    }
                }
            }
            
        }
        
        return 0;
    }
    
}
