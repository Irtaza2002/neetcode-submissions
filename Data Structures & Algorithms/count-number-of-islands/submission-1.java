class Solution {
    private static int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
    public int numIslands(char[][] grid) {
        int islands = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }
    private void dfs(char[][] grid, int row, int col){
        if(row<0 || col <0 || row>=grid.length || col>=grid[0].length ||
            grid[row][col]=='0'){
                return;
            }
        grid[row][col]='0';
        for(int[] dir: directions){
            dfs(grid, row+dir[0], col+dir[1]);
        }
    }
}
