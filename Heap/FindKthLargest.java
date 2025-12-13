import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        
        PriorityQueue<Integer> pq = 
            new PriorityQueue<>(Collections.reverseOrder());
        for (int i : nums) {
            pq.add(i);
        }
        if (k <= n / 2) {
            for (int i = 1; i < k; i++) {
                pq.poll();
            }
        } else {
            for (int i = 1; i <= n - k; i++) {
                pq.poll();
            }
        }

        return pq.peek();
    }
}