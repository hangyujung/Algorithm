import java.util.*;

    class Printer {
        public static int solution(int[] priorities, int location) {
            int answer = 0;
            Queue<a4> q = new LinkedList<>();

            for (int i = 0; i < priorities.length; i++) { // print큐에 인덱스번호, 우선순위 삽입
                q.offer(new a4(i, priorities[i]));
            }

            while (!q.isEmpty()) {

                boolean flag = false;
                int com = q.peek().prior;
                for (a4 p : q) {
                    if (com < p.prior) { // 맨앞의 수보다 큰 숫자가 존재하면
                        flag = true;
                    }
                }

                if (flag) {
                    q.offer(q.poll());

                }
                else {// 현재 맨앞의 숫자가 가장 클 때
                    if (q.poll().location == location) {     //poll() 해당욧를 반환하면서 큐에서 제거함,.
                        answer = priorities.length - q.size();
                    }
                }
            }
            return answer;
        }
        static class a4 {
            int location;
            int prior;

            a4(int location, int prior) {
                this.location = location;
                this.prior = prior;
            }
        }
        public static void main(String args[]){
            int a[]={1,1,9,1,1,1};
            int b=0;
            int res=solution(a, b);
            System.out.println(res);
        }
    }

//lv2 

