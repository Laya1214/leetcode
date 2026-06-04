class Solution {
    public int countPrimes(int n) {
        // Base case: no primes strictly less than 2
        if (n <= 2) {
            return 0;
        }

        // boolean array defaults to false
        // false will represent "prime", true will represent "composite"
        // This saves time because we do not need to fill the array with true initially
        boolean[] isComposite = new boolean[n];
        int count = 0;

        // Loop up to the square root of n
        int limit = (int) Math.sqrt(n);
        for (int i = 2; i <= limit; i++) {
            if (!isComposite[i]) {
                // Mark multiples of i as composite, starting from i * i
                for (int j = i * i; j < n; j += i) {
                    isComposite[j] = true;
                }
            }
        }

        // Count how many numbers remain unmarked (false) from 2 to n-1
        for (int i = 2; i < n; i++) {
            if (!isComposite[i]) {
                count++;
            }
        }

        return count;
    }
}
