class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int res=Integer.MAX_VALUE;
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i <= n; i++){
            while (!dq.isEmpty() && prefixSum[i] - prefixSum[dq.peekFirst()] >= k) {
                res = Math.min(res, i - dq.pollFirst()); 
            }
            while (!dq.isEmpty() && prefixSum[i] <= prefixSum[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.addLast(i);
        }
        return res!=Integer.MAX_VALUE?res:-1;
    }
}