class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length; 
        int col = grid[0].length; 

        boolean[][] visited = new boolean[row][col];

        int count = 0; 
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    dfs(grid, visited, i, j);
                    count++;
                }
            }
        }

        return count; 
    }

    public void dfs(char[][] grid, boolean[][] visited, int row, int col){
        
        int maxRow = grid.length; 
        int maxCol = grid[0].length; 

        if(row < 0 || row >= maxRow || col < 0 || col >= maxCol || visited[row][col] || grid[row][col] == '0')
            return; 
        
        visited[row][col] = true; 

        dfs(grid, visited, row, col-1); 
        dfs(grid, visited, row, col+1); 
        dfs(grid, visited, row-1, col);
        dfs(grid, visited, row+1, col);


    }
}
