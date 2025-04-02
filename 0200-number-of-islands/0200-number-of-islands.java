// class Solution {
//     private int m;
//     private int n;
//     public int[][] dirs ={{0,1},{0,-1},{-1,0},{1,0}};

//     private void bfs(char[][]grid, int r, int c){
//         Queue<int[]> queue = new LinkedList<>();
//         queue.offer(new int[]{r,c});

//         while(!queue.isEmpty()){
//             int[] curr = queue.poll();

//             for(int[] dir : dirs){
//                 int newRow = curr[0]+dir[0];
//                 int newColumn = curr[1]+dir[1];

//                 if(0<=newRow && newRow<m && 0<=newColumn && newColumn<n && grid[newRow][newColumn]=='1'){
//                     grid[newRow][newColumn]='0';
//                     queue.offer(new int[]{newRow,newColumn});
//                 }
//             }
//         }
//     }
 
 
//     public int numIslands(char[][] grid) {
//         m=grid.length;
//         n=grid[0].length;
//         int count =0;

//         for(int r=0;r<m;r++){
//             for(int c=0;c<n;c++){
//                 if(grid[r][c]=='1'){
//                     count++;
//                     bfs(grid,r,c);
//                 }
//             }
//         }
//         return count;
//     }
// }

class Solution {
    void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    dfs(grid, r, c);
                }
            }
        }

        return num_islands;
    }
}