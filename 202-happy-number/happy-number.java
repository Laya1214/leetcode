class Solution {
    private int sum2(int n){
        int sum=0;
        int b=n;
        while(b>0){
            int n1=b%10;
            sum=sum+(n1*n1);
            b=b/10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        int a=n;
        int b=n;
        if(a==1)return true;
        int slow=n;
        int fast=n;
        slow=sum2(slow);
        fast=sum2(sum2(fast));
        while(slow!=fast){
            slow=sum2(slow);
            fast=sum2(sum2(fast));
            
        }
        return slow==1;
    }
}