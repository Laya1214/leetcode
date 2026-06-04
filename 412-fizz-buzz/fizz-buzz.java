class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res=new ArrayList<>();
        for(int i=1;i<=n;i++){
            boolean isdivib3=(i%3==0);
            boolean isdivb5=(i%5==0);
            if(isdivib3 && isdivb5)res.add("FizzBuzz");
            else if(isdivib3)res.add("Fizz");
            else if(isdivb5)res.add("Buzz");
            else res.add(Integer.toString(i));
        }
        return res;
    }
}