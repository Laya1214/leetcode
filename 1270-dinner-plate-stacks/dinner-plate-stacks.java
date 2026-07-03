class DinnerPlates {
    List<Stack<Integer>> l;
    TreeSet<Integer> ts;
    int cap;
    public DinnerPlates(int capacity) {
        l=new ArrayList<>();
        ts=new TreeSet<>();
        this.cap=capacity;
    }
    
    public void push(int val) {
        if(ts.isEmpty()){
            Stack<Integer> inst=new Stack<>();
            inst.push(val);
            l.add(inst);
            if(inst.size()<cap){
                ts.add(l.size()-1);
            }
        }
        else{
            int i=ts.first();
            Stack<Integer> inst=l.get(i);
            inst.push(val);
            if(inst.size()==cap){
                ts.remove(i);
            }
        }      
    }
    
    public int pop() {
        if(l.isEmpty()){
            return -1;
        }
        while(!l.isEmpty() && l.get(l.size()-1).isEmpty()){
            ts.remove(l.size()-1);
            l.remove(l.size()-1);
        }
         if(l.isEmpty()){
            return -1;
        }
        int i=l.size()-1;
        Stack<Integer> inst=l.get(i);
        int res=inst.pop();
        ts.add(i);
        while(!l.isEmpty()&&l.get(l.size()-1).isEmpty()){
            ts.remove(l.size()-1);
            l.remove(l.size()-1);
        }
        return res;

    }
    
    public int popAtStack(int index) {
        if (index < 0 || index >= l.size() || l.get(index).isEmpty()) {
            return -1;
        }
        int res=l.get(index).pop();
        ts.add(index);
        return res;
    }
}

/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */