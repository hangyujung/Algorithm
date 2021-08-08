import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue();

        for (int aScoville : scoville) {
            heap.add(aScoville);
        }

        while (heap.peek() < K) {
            if (heap.size() == 1) {
                return -1;
            }
            int a = heap.remove();
            int b = heap.remove();


            int result = a + (b * 2);

            heap.add(result);
            answer ++;
        }
        return answer;
    }
}
