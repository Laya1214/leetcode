class Solution {
    public boolean sumGame(String num) {
        int s1=0;
        int s2=0;
        int c1=0;
        int c2=0;
        int left=0;
        int right=num.length()-1;
        while(left<right){
            if(num.charAt(left)=='?'){
                c1++;
            }
            else{
                int n=num.charAt(left)-'0';
                s1+=n;
            }
            if(num.charAt(right)=='?'){
                c2++;
            }
            else{
                int n1=num.charAt(right)-'0';
                s2+=n1;
            }
            left++;
            right--;
        }
        int sum=s1-s2;
        int count=9*((c2-c1)/2);
        if(((c1+c2)&1)!=0)return true;
        else{
            if(sum==count)return false;     
        }
        return true;
    }
}