class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        int MOD=1_000_000_007;
        Arrays.sort(arr);
        long total=0;
        Map<Integer,Long> dp=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            long count=1;
            for(int j=0;j<i;j++){
                if(arr[i]%arr[j]==0){
                    int right=arr[i] / arr[j];
                    if(dp.containsKey(right)){
                        long leftways=dp.get(arr[j]);
                        long rightways=dp.get(right);
                        long ways=(leftways * rightways) % MOD;
                        count=(count + ways) % MOD;
                    }
                }
            }
            dp.put(arr[i],count);
            total=(total+count)%MOD;
        }
        return (int) total;
    }
}