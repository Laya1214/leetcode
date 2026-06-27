class RecentCounter {
    Queue<Integer> t1;
    public RecentCounter() {
        t1=new LinkedList<>();
    }
    
    public int ping(int t) {
        t1.add(t);
        while(!t1.isEmpty() && t1.peek() < t-3000){
            t1.poll();
        }
        return t1.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */