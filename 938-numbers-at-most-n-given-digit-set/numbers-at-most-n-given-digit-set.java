class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String s=String.valueOf(n);
        double sum=0;
        int m=digits.length;
        int k=s.length();
        for(int i=1;i<k;i++){
            sum=sum+(Math.pow(m,i));
        }
        for(int i=0;i<k;i++){
            boolean isd=false;
            for (String d : digits) {
                if (d.charAt(0) < s.charAt(i)) {
                    sum += Math.pow(m, k - i - 1);
                } else if (d.charAt(0) == s.charAt(i)) {
                    isd = true;
                }
            }
            if (!isd) return (int)sum;
        }
        return (int)sum+1;
    }
}