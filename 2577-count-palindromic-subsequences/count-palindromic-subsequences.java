class Solution {
    public int countPalindromes(String s) {
        int n = s.length();
        int MOD = 1_000_000_007;
        long total = 0;
        int[][][] suffix = new int[n][10][10];
        int[] suffixDC = new int[10];
        for (int i = n - 1; i >= 0; i--) {
            int cD = s.charAt(i) - '0';
            if (i < n - 1) {
                for (int d1 = 0; d1 < 10; d1++) {
                    for (int d2 = 0; d2 < 10; d2++) {
                        suffix[i][d1][d2] = suffix[i + 1][d1][d2];
                    }
                }
            }
            for (int nD = 0; nD < 10; nD++) {
                suffix[i][cD][nD] = (suffix[i][cD][nD] + suffixDC[nD]) % MOD;
            }
            suffixDC[cD]++;
        }
        int[][] prefix = new int[10][10];
        int[] prefixDC = new int[10];
        for (int i = 0; i < n; i++) {
            int cD = s.charAt(i) - '0';
            if (i > 1 && i < n - 2) {
                for (int d1 = 0; d1 < 10; d1++) {
                    for (int d2 = 0; d2 < 10; d2++) {
                        long lP = prefix[d1][d2];
                        long rP = suffix[i + 1][d2][d1]; 
                        total = (total + (lP * rP) % MOD) % MOD;
                    }
                }
            }
            for (int prevD = 0; prevD < 10; prevD++) {
                prefix[prevD][cD] = (prefix[prevD][cD] + prefixDC[prevD]) % MOD;
            }
            prefixDC[cD]++;
        }
        return (int) total;
    }
}
