class Solution {
    private static int sum(int d){
        //int d=n;
        int sum=0;
        while(d>0){
            int r=d%10;
            sum+=r;
            d=d/10;
        }
        return sum;
    }
    private static int product(int d){
        //int d=n;
        int p=1;
        while(d>0){
            int r=d%10;
            p*=r;
            d=d/10;
        }
        return p;
    }
    public boolean checkDivisibility(int n) {
        return (n%(sum(n)+product(n))==0);
    }
}