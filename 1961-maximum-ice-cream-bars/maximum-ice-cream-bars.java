class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int total=0;
        
        for(int i:costs){
            if(coins>=i){
                coins-=i;
                total+=1;
            }
            else{
                break;
            }
        }
        return total;
    }
}