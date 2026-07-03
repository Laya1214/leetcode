class FreqStack {
    Map<Integer,Integer> hm;
    Map<Integer,Stack<Integer>> freq;
    int maxi;
    public FreqStack() {
        hm=new HashMap<>();
        freq=new HashMap<>();
        maxi=0;
    }

    public void push(int val) {
       int f=hm.getOrDefault(val,0)+1;
       hm.put(val,f);
        if(f>maxi){
            maxi=f;
        }
        freq.putIfAbsent(maxi,new Stack<>());
        freq.get(f).push(val);
    }
    
    public int pop() {
        int val=freq.get(maxi).pop();
        hm.put(val,hm.get(val)-1);
        if(freq.get(maxi).isEmpty()){
            maxi--;
        }
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */