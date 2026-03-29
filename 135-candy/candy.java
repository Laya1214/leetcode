class Solution {
    private static int sum(int[] num){
        int n=num.length;
        int c=0;
        for(int nums:num){
            c+=nums;
        }
        return c;
    }
    public int candy(int[] ratings) {
        int[] cand=new int[ratings.length];
        Arrays.fill(cand,1);
        int n=ratings.length;
        if (n <= 1) return n;
        if(ratings[0]>ratings[1]){cand[0]+=1;}
        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1]){
                cand[i]=cand[i-1]+1;
            }
        }
         for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                cand[i] = Math.max(cand[i], cand[i + 1] + 1);
            }
        }
        return sum(cand);
    }
}