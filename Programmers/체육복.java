class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer=0;
        int ok=0;
        for(int j=0;j<reserve.length;j++){
            for(int i=0;i<lost.length;i++){
                if(reserve[j]==lost[i]){
                    lost[i]=-1;
                    reserve[j]=-1;
                    ok++;
               
                    break;
                }
            }
          
        }

              
        
        for(int data:reserve){
            
            for(int i=0;i<lost.length;i++){
            
                if(data!=-1 && (data-1)==lost[i]){
                    lost[i]=-1;
                    //reverse[j]=-1;
                    ok++;
                     
                    break;
                }
                 if(data!=-1 &&(data+1)==lost[i]){
                    lost[i]=-1;
                    //reverse[j]=-1;
                    ok++;
                      
                    break;
                }
            }
        }
    
  
        answer=n-lost.length+ok;
        return answer;
    }
}

//그리디 탐욕법 Lv1
