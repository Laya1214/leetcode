class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
    
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] time : times) {
            adj.computeIfAbsent(time[0], key -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, k});
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int d = current[0];
            int u = current[1];
            if (d > dist[u]) continue;
            if (adj.containsKey(u)) {
                for (int[] edge : adj.get(u)) {
                    int v = edge[0];
                    int weight = edge[1];
                    if (dist[u] + weight < dist[v]) {
                        dist[v] = dist[u] + weight;
                        pq.offer(new int[]{dist[v], v});
                    }
                }
            }
        }
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1; 
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}
