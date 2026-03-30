class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (dfs(board, word, i, j, 0)) return true;
        return false;
    }

    private boolean dfs(char[][] b, String w, int r, int c, int i) {
        if (i == w.length()) return true;
        if (r < 0 || r >= b.length || c < 0 || c >= b[0].length || b[r][c] != w.charAt(i)) return false;

        char tmp = b[r][c];
        b[r][c] = '#'; 
        
        boolean found = dfs(b, w, r+1, c, i+1) || dfs(b, w, r-1, c, i+1) || 
                        dfs(b, w, r, c+1, i+1) || dfs(b, w, r, c-1, i+1);
        b[r][c] = tmp; 
        return found;
    }
}
