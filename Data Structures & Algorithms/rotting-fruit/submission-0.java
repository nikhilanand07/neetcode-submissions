class Solution {
    public int orangesRotting(int[][] grid) {
        int maxRow = grid.length; 
        int maxCol = grid[0].length; 

        int fresh = 0, time = 0; 
        Queue<int[]> q = new ArrayDeque<>(); 

        for(int i=0; i<maxRow; i++){
            for(int j=0; j<maxCol; j++){
                if(grid[i][j] == 1)
                    fresh++; 
                else if(grid[i][j] == 2)
                    q.offer(new int[]{i, j});

            }
        }

        int[][] dir = {
            {0, -1}, 
            {0, 1}, 
            {1, 0}, 
            {-1, 0}
        }; 

        while(!q.isEmpty() && fresh > 0){
            int size = q.size(); 

            for(int i=0; i<size;i++){
                int[] curr = q.poll(); 
                int r = curr[0]; 
                int c = curr[1]; 

                for(int[] d : dir){
                    int qRow = r + d[0]; 
                    int qCol = c + d[1]; 

                    if(qRow >= 0 && qRow < maxRow && qCol >= 0 && qCol < maxCol && grid[qRow][qCol] == 1 ){
                        grid[qRow][qCol] = 2; 
                        q.offer(new int[]{qRow, qCol}); 
                        fresh--; 
                    }
                }
            }
            time++; 
        }

        return fresh == 0 ? time : -1; 
    }
}
