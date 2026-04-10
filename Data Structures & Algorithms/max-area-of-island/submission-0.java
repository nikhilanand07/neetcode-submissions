class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length; 
        int col = grid[0].length; 

        boolean[][] visited = new boolean[row][col]; 
        int maxArea = 0; 
        List<int[]> list = new ArrayList(); 
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    dfs(grid, visited, i, j, list);
                    if(maxArea < list.size()){
                        maxArea = list.size(); 
                    }

                    list = new ArrayList(); 
                }
            }
        }

        return maxArea;
    }

    public void dfs(int[][] grid, boolean[][] visited, int row, int col, List<int[]> list){
        int maxRow = grid.length; 
        int maxCol = grid[0].length; 

        if(row < 0 || row >= maxRow || col < 0 || col >= maxCol || visited[row][col] || grid[row][col] == 0)
            return; 

        visited[row][col] = true;
        list.add(new int[]{row, col}); 

        dfs(grid, visited, row, col-1, list);
        dfs(grid, visited, row, col+1, list);
        dfs(grid, visited, row-1, col, list);
        dfs(grid, visited, row+1, col, list);

    }
}
