class Solution {
    public int maxAreaOfIsland(int[][] grid) {
         if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int rows = grid.length;
        int cols = grid[0].length;
        int islandCount = 0;
        
        
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int maxi=0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int c1=0;
                
                if (grid[r][c] == 1) {
                    islandCount++;
                    grid[r][c] = 0; 
                    c1+=1;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{r, c});
                    
                    while (!queue.isEmpty()) {
                        int[] cell = queue.poll();
                        int currRow = cell[0];
                        int currCol = cell[1];
                        
                        
                        for (int[] dir : directions) {
                            int nextRow = currRow + dir[0];
                            int nextCol = currCol + dir[1];
                            
                            
                            if (nextRow >= 0 && nextRow < rows && 
                                nextCol >= 0 && nextCol < cols && 
                                grid[nextRow][nextCol] == 1) {
                                c1++;
                                queue.offer(new int[]{nextRow, nextCol});
                                grid[nextRow][nextCol] = 0; 
                            }
                        }
                    }
                }
                maxi=Math.max(maxi,c1);
            }
        }
        
        return maxi;
    }
}