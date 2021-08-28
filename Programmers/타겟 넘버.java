
// class Solution {
//     public int solution(int[] numbers, int target) {
//         int answer = 0;
//         answer = dfs(numbers, 0, 0, target);
//         return answer;
//     }
//     int dfs(int[] numbers, int n, int sum, int target) {
//         if(n == numbers.length) {
//             if(sum == target) {
//                 return 1;
//             }
//             return 0;
//         }
//         return dfs(numbers, n + 1, sum + numbers[n], target) + dfs(numbers, n + 1, sum - numbers[n], target);
//     }
// }



class Solution {
    static boolean visited[];
    static int total,count,N;
    //static int[] numbers;
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        N = numbers.length;
        visited=new boolean[N];
       // numbers=numbers;
        for(int data:numbers){
            total+=data;
        }
        powerSet(target, 0, numbers);
        return count;
    }
    
    static void powerSet(int target, int num,int[] numbers){
        if(num==N){
            int sum=0;
       
            for(int i=0;i<visited.length;i++){
                if(visited[i]) sum+= numbers[i];
                else { sum -= numbers[i];}
            }
            if(sum==target) {
                count++;
                System.out.println(sum);
            } 
            return;
        }
        
      
            visited[num] = true;
            powerSet(target,num+1,numbers);
            visited[num]= false;
            powerSet(target,num+1,numbers);
        
    }
}
//DFS/BFS LV2
