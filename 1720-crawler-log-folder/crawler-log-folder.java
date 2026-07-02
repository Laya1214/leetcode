class Solution {
    public int minOperations(String[] logs) {
        int d=0;
        int n=logs.length;
        for(int i=0;i<n;i++){
            if(logs[i].equals("../")){
                if(d>0){
                    d--;
                }
            }
            else if(logs[i].equals("./")) continue;
            else{
                d++;
            }
        }
        return d;
    }
}