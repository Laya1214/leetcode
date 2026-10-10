class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long sum=0;
        long k=(long)k1+k2;
        int[] freq=new int[100002];
        int md=0;
        for(int i=0;i<nums1.length;i++){
            int df=Math.abs(nums1[i]-nums2[i]);
            if(df>0){
                freq[df]++;
                md=Math.max(md,df);
            }
        }
        for(int i=md;i>0;i--){
            if(freq[i]==0)continue;
            if(k>=freq[i]){
                k-=freq[i];
                freq[i-1]+=freq[i];
                freq[i]=0;
            }
            else{
                freq[i-1]+=k;
                freq[i]-=k;
                k=0;
                break;
            }
        }
        for(int i=1;i<=md;i++){
            if(freq[i]>0){
                sum+=(long)freq[i]*i*i;
            }
        }
        return sum;
    }
}