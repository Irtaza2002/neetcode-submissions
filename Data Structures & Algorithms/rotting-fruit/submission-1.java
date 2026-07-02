class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        int time = 0;
        Queue<int[]> q = new ArrayDeque<>();

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j] == 1){
                    fresh++;
                }
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                }
            }
        }
        int[][] directions = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        while(!q.isEmpty() && fresh > 0){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] temp = q.poll();
                int r = temp[0];
                int c = temp[1];
                for(int[] dir: directions){
                    int row = dir[0] + r;
                    int col = dir[1] + c;
                    if(row>=0 && row<grid.length && 
                    col>=0 && col<grid[0].length && 
                    grid[row][col]==1){
                        grid[row][col]=2;
                        q.offer(new int[]{row,col});
                        fresh--;
                    }
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}
